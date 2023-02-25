package BMS.book_my_show.Service;

import BMS.book_my_show.Converters.UserConverter;
import BMS.book_my_show.DTOs.UserRequestDTO;
import BMS.book_my_show.Models.Theatre;
import BMS.book_my_show.Models.User;
import BMS.book_my_show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service layer throws exception
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequestDTO userRequestDTO) throws Exception {
        User user = UserConverter.convertDtoToEntity(userRequestDTO);
        userRepository.save(user);

        return "User added";
    }
}
