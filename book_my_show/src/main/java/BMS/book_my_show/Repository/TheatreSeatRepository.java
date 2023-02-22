package BMS.book_my_show.Repository;

import BMS.book_my_show.Models.TheatreSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeats, Integer> {
}
