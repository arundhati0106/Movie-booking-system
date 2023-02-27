package BMS.book_my_show.DTOs;

import BMS.book_my_show.Enums.SeatType;
import BMS.book_my_show.Models.Movie;
import BMS.book_my_show.Models.ShowSeats;
import BMS.book_my_show.Models.Theatre;
import BMS.book_my_show.Models.Ticket;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequestDTO {
    private LocalDate showDate;
    private LocalTime showTime;

    private int movieId;
    private int theatreId;

    private double classicSeatPrice;
    private double premiumSeatPrice;
}
