package BMS.book_my_show.Service;

import BMS.book_my_show.Converters.TheatreConverter;
import BMS.book_my_show.DTOs.TheatreRequestDTO;
import BMS.book_my_show.Enums.SeatType;
import BMS.book_my_show.Models.Theatre;
import BMS.book_my_show.Models.TheatreSeats;
import BMS.book_my_show.Repository.TheatreRepository;
import BMS.book_my_show.Repository.TheatreSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    public String addTheatre(TheatreRequestDTO theatreRequestDTO) throws Exception {

        //validations
        if(theatreRequestDTO.getName() == null || theatreRequestDTO.getCity() == null) {
            throw new Exception("Name and location should be valid");
        }

        //already exists

        /*
        create theatre seats
        create theatre entity
        set entity attributes from entry DTO
        save theatre in repo
        */

        //theatre entity
        Theatre theatre = TheatreConverter.convertDTOtoEntity(theatreRequestDTO);

        //theatre seat entity
        List<TheatreSeats> theatreSeatsList = addTheatreSeat(theatreRequestDTO, theatre);

        //set attributes
        //set seats to theatre
        theatre.setSeats(theatreSeatsList);

        //save
        theatreRepository.save(theatre);

        return "theatre and seats added";
    }

    public List<TheatreSeats> addTheatreSeat(TheatreRequestDTO theatreRequestDTO, Theatre theatre) {
        int classicSeats = theatreRequestDTO.getClassicSeatCount();
        int premiumSeats = theatreRequestDTO.getPremiumSeatCount();

        List<TheatreSeats> theatreSeatsList = new ArrayList<>();

        //set classic seats
        for(int count = 1; count <= classicSeats; count++) {
            //make new theatre seat entity
            TheatreSeats theatreSeats = TheatreSeats.builder()
                    .seatType(SeatType.CLASSIC)
                    .seatNumber(count+"C")
                    .theatre(theatre) //set foreign key... this seat belongs to which theatre (param)
                    .build();

            //add seats to list of seats in theatre
            theatreSeatsList.add(theatreSeats);
        }

        //set premium seats
        for(int count = 1; count <= premiumSeats; count++) {
            //make new theatre seat entity
            TheatreSeats theatreSeats = TheatreSeats.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNumber(count+"P")
                    .theatre(theatre) //set foreign key... this seat belongs to which theatre
                    .build();

            theatreSeatsList.add(theatreSeats);
        }

        return theatreSeatsList;
    }
}
