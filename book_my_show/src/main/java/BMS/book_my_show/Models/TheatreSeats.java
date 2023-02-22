package BMS.book_my_show.Models;

import BMS.book_my_show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatre_seats")

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TheatreSeats {
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNumber;

    private double price;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    //mapping
    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
