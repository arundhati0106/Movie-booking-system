package BMS.book_my_show.Repository;

import BMS.book_my_show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

//deals with Entity / model layers, as it represents SQL tables
public interface UserRepository extends JpaRepository<User, Integer> {

}
