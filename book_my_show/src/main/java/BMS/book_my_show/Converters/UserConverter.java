package BMS.book_my_show.Converters;

import BMS.book_my_show.DTOs.UserRequestDTO;
import BMS.book_my_show.Models.User;

//convert DTO to Entity, called by service layer, as Repo handles only entity
//separate class -> to enforce SPR(Single Point Responsibility)
public class UserConverter {
    //object -> time and space required, so avoid by making it static
    public static User convertDtoToEntity(UserRequestDTO userRequestDTO) {
        User user = User.builder().name(userRequestDTO.getName())
                .age(userRequestDTO.getAge())
                .emailId(userRequestDTO.getEmailId())
                .mobile(userRequestDTO.getMobile())
                .city(userRequestDTO.getCity()).build();

        return user;
    }
}
