package BMS.book_my_show.Controllers;

import BMS.book_my_show.DTOs.MovieRequestDTO;
import BMS.book_my_show.Service.MovieService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
@Data
@Builder
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("add")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        try {
            String response = movieService.addMovie(movieRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            String result = "Movie couldn't be added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

}
