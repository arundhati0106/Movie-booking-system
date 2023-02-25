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

    public String addTheatre(TheatreRequestDTO theatreRequestDTO) {
        /*
        create theatre seats
        create theatre entity
        set entity attributes from entry DTO
        save theatre in repo
        */

        Theatre theatre = TheatreConverter.convertDTOtoEntity(theatreRequestDTO);

        List<TheatreSeats> theatreSeatsList = new ArrayList<>();


//        theatreSeatsList.add(addTheatreSeat("A_01", 300, SeatType.CLASSIC));
//        theatreSeatsList.add(addTheatreSeat("B_01", 500, SeatType.PREMIUM));
//
//        for(TheatreSeats seats: theatreSeatsList) {
//            seats.setTheatre(theatre);
//        }

        theatre.setSeats(theatreSeatsList);
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

        theatreSeatRepository.saveAll(theatreSeatsList);
        return theatreSeatsList;
    }

//    public TheatreSeats addTheatreSeat(String seat_no, int rate, SeatType seatType) {
//        return TheatreSeats.builder().seatNumber(seat_no).price(rate).seatType(seatType).build();
//    }
}
