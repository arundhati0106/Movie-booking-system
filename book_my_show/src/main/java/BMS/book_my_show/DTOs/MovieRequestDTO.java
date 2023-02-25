package BMS.book_my_show.DTOs;

import BMS.book_my_show.Enums.CertificateType;
import BMS.book_my_show.Enums.Genre;
import BMS.book_my_show.Enums.MovieLanguage;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequestDTO {
    private String name;
    private double rating;
    private double duration;
    private BMS.book_my_show.Enums.Genre Genre;
    private MovieLanguage language;
    private CertificateType certificateType;
    private LocalDate releaseDate;
}
