package BMS.book_my_show.Service;

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
        Theatre theatre = Theatre.builder().name(theatreRequestDTO.getName())
                .city(theatreRequestDTO.getCity()).address(theatreRequestDTO.getAddress())
                .build();

        List<TheatreSeats> theatreSeatsList = new ArrayList<>();

        theatreSeatsList.add(addTheatreSeat("A_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("A_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("A_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("A_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("B_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("B_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("B_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("B_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("C_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("C_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("C_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("C_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("D_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("D_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("D_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("D_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("E_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("E_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("E_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("E_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("F_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("F_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("F_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("F_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("G_01", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("G_02", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("G_03", 300, SeatType.CLASSIC));
        theatreSeatsList.add(addTheatreSeat("G_04", 300, SeatType.CLASSIC));

        theatreSeatsList.add(addTheatreSeat("H_01", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("H_02", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("H_03", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("H_04", 500, SeatType.PREMIUM));

        theatreSeatsList.add(addTheatreSeat("I_01", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("I_02", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("I_03", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("I_04", 500, SeatType.PREMIUM));


        theatreSeatsList.add(addTheatreSeat("J_01", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("J_02", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("J_03", 500, SeatType.PREMIUM));
        theatreSeatsList.add(addTheatreSeat("J_04", 500, SeatType.PREMIUM));

        for(TheatreSeats seats: theatreSeatsList) {
            seats.setTheatre(theatre);
        }

        theatre.setSeats(theatreSeatsList);
        theatreRepository.save(theatre);
        return "theatre and seats added";
    }

    public TheatreSeats addTheatreSeat(String seat_no, int rate, SeatType seatType) {
        return TheatreSeats.builder().seatNumber(seat_no).price(rate).seatType(seatType).build();
    }
}
