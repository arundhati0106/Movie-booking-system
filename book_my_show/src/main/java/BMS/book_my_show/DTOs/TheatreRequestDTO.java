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

    @NonNull
    private String city;

    private String address;
}
