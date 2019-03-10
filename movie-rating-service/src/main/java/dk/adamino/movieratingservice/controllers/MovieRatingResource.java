package dk.adamino.movieratingservice.controllers;

import dk.adamino.movieratingservice.models.Rating;
import dk.adamino.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class MovieRatingResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 6.0);
    }

    @GetMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return new UserRating(
                Arrays.asList(
                        new Rating("1234", 5.0),
                        new Rating("5678", 3.0)
                )
        );
    }
}
