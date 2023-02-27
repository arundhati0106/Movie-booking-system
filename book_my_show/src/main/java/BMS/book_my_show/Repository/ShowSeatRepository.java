package BMS.book_my_show.Repository;

import BMS.book_my_show.Models.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeats, Integer> {
}
