package BMS.book_my_show.Controllers;

import BMS.book_my_show.DTOs.ShowRequestDTO;
import BMS.book_my_show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowService showService;

    public ResponseEntity<String> addShow(ShowRequestDTO showRequestDTO) {
        try {
            String result = showService.addShow(showRequestDTO);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
