package BMS.book_my_show.Controllers;

import BMS.book_my_show.DTOs.UserRequestDTO;
import BMS.book_my_show.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j  //annotation for logs
public class UserController {
    @Autowired
    UserService userService;

    //exception handling -> try catch
    @PostMapping("add")
    public ResponseEntity<String> addUser(UserRequestDTO userRequestDTO) {
        try {
            String response = userService.addUser(userRequestDTO);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            String result = "User couldn't be added";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("printLogs")
    public String printLogs() {

        //advanced way of writing print commands/statements
        log.trace("This is a trace");
        log.debug("This is a debug");
        log.info("This is an info");
        log.warn("This is a warning");
        log.error("This is an error");

        return "Printed logs";
    }
}
