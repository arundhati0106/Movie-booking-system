package BMS.book_my_show.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreRequestDTO {
    private String name;
    private String city;
    private String address;

    //theatre seats... no of classic and premium seats
    private int classicSeatCount;
    private int premiumSeatCount;

    //no need to have price attribute as that would be in show DTO,
    //while creating theatre, design matters
}
