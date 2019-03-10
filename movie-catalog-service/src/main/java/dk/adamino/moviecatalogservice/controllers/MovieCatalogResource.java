package dk.adamino.moviecatalogservice.controllers;

import dk.adamino.moviecatalogservice.models.CatalogItem;
import dk.adamino.moviecatalogservice.models.Movie;
import dk.adamino.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private static final String MOVIES_PATH = "http://localhost:1338/movies/";
    private static final String RATINGS_PATH = "http://localhost:1339/ratings/";

    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public MovieCatalogResource(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = restTemplate.getForObject(RATINGS_PATH + "/users/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject(MOVIES_PATH + rating.getMovieId(), Movie.class);

                    // In the future we're going to do it like this, when RestTemplate gets deprecated... Sigh
                    /*Movie movie = webClientBuilder.build()
                            .get()
                            .uri(MOVIES_PATH + rating.getMovieId())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block();*/

                    return new CatalogItem(movie.getTitle(), "Test", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
