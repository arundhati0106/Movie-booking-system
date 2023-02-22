package BMS.book_my_show.Models;

import BMS.book_my_show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "show_seats")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNumber;

    private double price;

    private boolean isBooked;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    //mapping
    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;
}
