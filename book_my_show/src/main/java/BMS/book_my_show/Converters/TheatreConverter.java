package BMS.book_my_show.Converters;

import BMS.book_my_show.DTOs.TheatreRequestDTO;
import BMS.book_my_show.Models.Theatre;

public class TheatreConverter {
    public static Theatre convertDTOtoEntity(TheatreRequestDTO theatreRequestDTO) {
        Theatre theatre = Theatre.builder().name(theatreRequestDTO.getName())
                .city(theatreRequestDTO.getCity())
                .address(theatreRequestDTO.getAddress())
                .build();

        return theatre;
    }
}
