package BMS.book_my_show.Repository;

import BMS.book_my_show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
