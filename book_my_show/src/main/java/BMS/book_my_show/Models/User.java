package BMS.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

//lombok dependency -> make getter, setter, constructor using annotations
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //parameters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true, nullable = false)
    private String emailId;

    @NonNull
    @Column(unique = true)
    private String mobile;

    private String city;

    //mapping
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
}
