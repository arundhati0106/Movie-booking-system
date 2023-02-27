package BMS.book_my_show.Converters;

import BMS.book_my_show.DTOs.ShowRequestDTO;
import BMS.book_my_show.Models.Show;
import jakarta.persistence.Entity;

public class ShowConverter {
    public static Show convertDTOtoEntity(ShowRequestDTO showRequestDTO) {
        Show show = Show.builder()
                .showDate(showRequestDTO.getShowDate())
                .showTime(showRequestDTO.getShowTime())
                .build();

        return show;
    }
}
