package BMS.book_my_show.Service;

import BMS.book_my_show.Converters.MovieConverter;
import BMS.book_my_show.DTOs.MovieRequestDTO;
import BMS.book_my_show.Models.Movie;
import BMS.book_my_show.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDTO movieRequestDTO) {
        Movie movie = MovieConverter.convertDtoToEntity(movieRequestDTO);
        return "Movie added successfully.";
    }
}
