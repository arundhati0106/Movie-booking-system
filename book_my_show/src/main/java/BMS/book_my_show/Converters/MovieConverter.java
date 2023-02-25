package BMS.book_my_show.Converters;

import BMS.book_my_show.DTOs.MovieRequestDTO;
import BMS.book_my_show.DTOs.UserRequestDTO;
import BMS.book_my_show.Enums.CertificateType;
import BMS.book_my_show.Enums.MovieLanguage;
import BMS.book_my_show.Models.Movie;
import BMS.book_my_show.Models.User;

import java.time.LocalDate;

public class MovieConverter {
    public static Movie convertDtoToEntity(MovieRequestDTO movieRequestDTO) {
        Movie movie = Movie.builder().name(movieRequestDTO.getName())
                .language(movieRequestDTO.getLanguage())
                .rating(movieRequestDTO.getRating())
                .Genre(movieRequestDTO.getGenre())
                .duration(movieRequestDTO.getDuration())
                .certificateType(movieRequestDTO.getCertificateType())
                .releaseDate(movieRequestDTO.getReleaseDate())
                .build();

        return movie;
    }
}
