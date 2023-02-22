package BMS.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
//@Data annotation handles @RequiredArgsConstrustor, @ToString, @Getter, @Setter
@Data
public class Ticket {
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    private String bookedSeats;

    //mapping
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Show show;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<ShowSeats> seats = new ArrayList<>();
}
