package BMS.book_my_show.Controllers;

import BMS.book_my_show.DTOs.TheatreRequestDTO;
import BMS.book_my_show.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @PostMapping("add")
    public String addTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO) {
        return theatreService.addTheatre(theatreRequestDTO);
    }
}
