package BMS.book_my_show.Repository;

import BMS.book_my_show.Enums.MovieLanguage;
import BMS.book_my_show.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
