package BMS.book_my_show.Service;

import BMS.book_my_show.Converters.ShowConverter;
import BMS.book_my_show.DTOs.ShowRequestDTO;
import BMS.book_my_show.Enums.SeatType;
import BMS.book_my_show.Models.*;
import BMS.book_my_show.Repository.MovieRepository;
import BMS.book_my_show.Repository.ShowRepository;
import BMS.book_my_show.Repository.ShowSeatRepository;
import BMS.book_my_show.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    public String addShow(ShowRequestDTO showRequestDTO) {
        //create show entity
        Show show = ShowConverter.convertDTOtoEntity(showRequestDTO);
        int movieId = showRequestDTO.getMovieId();
        int theatreId = showRequestDTO.getTheatreId();

        Movie movie = movieRepository.findById(movieId).get();
        Theatre theatre = theatreRepository.findById(theatreId).get();

        //set attributes of foreign key
        movie.getShows().add(show);
        show.setMovie(movie);

        theatre.getShows().add(show);
        show.setTheatre(theatre);

        //set attributes of list of show seats
        List<ShowSeats> showSeatsList = addShowSeats(showRequestDTO, show);
        show.setSeats(showSeatsList);

        //update parent entities
        //movie
        List<Show> showList = movie.getShows();
        showList.add(show);
        movie.setShows(showList);
        movieRepository.save(movie);

        //theatre
        List<Show> showList1 = theatre.getShows();
        showList1.add(show);
        theatre.setShows(showList1);
        theatreRepository.save(theatre);

        return "Show and show seats added";
    }

    private List<ShowSeats> addShowSeats(ShowRequestDTO showRequestDTO, Show show) {
        //create show seat entity
        //set attributes

        //theatre seats
        //show is in a fixed theatre -> from there we get the list of theatre seats
        List<TheatreSeats> theatreSeatsList = show.getTheatre().getSeats();

        //show seats
        List<ShowSeats> showSeatsList = new ArrayList<>();

        //for each theatre seat, make a show seat entity
        for(TheatreSeats theatreSeats: theatreSeatsList) {
            ShowSeats showSeats = new ShowSeats();

            //set attributes
            showSeats.setSeatNumber(theatreSeats.getSeatNumber());
            showSeats.setSeatType(theatreSeats.getSeatType());

            if(theatreSeats.getSeatType().equals(SeatType.CLASSIC)) {
                showSeats.setPrice(showRequestDTO.getClassicSeatPrice());
            }
            else
                showSeats.setPrice(showRequestDTO.getPremiumSeatPrice());

            showSeats.setBooked(false);
            showSeats.setShow(show); //foreign key -> set show

            //set show seats to show seat list
            showSeatsList.add(showSeats);
        }

        showSeatRepository.saveAll(showSeatsList);
        return showSeatsList;
    }
}
