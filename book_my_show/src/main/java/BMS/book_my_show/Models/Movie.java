package BMS.book_my_show.Models;

import BMS.book_my_show.Enums.CertificateType;
import BMS.book_my_show.Enums.Genre;
import BMS.book_my_show.Enums.MovieLanguage;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.cert.Certificate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double rating;

    private double duration;

    @Enumerated(EnumType.STRING)
    private Genre Genre;

    @Enumerated(EnumType.STRING)
    private MovieLanguage language;

    @Enumerated(EnumType.STRING)
    private CertificateType certificateType;

    private LocalDate releaseDate;

    //mapping
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();
}
