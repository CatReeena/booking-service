package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReadingService {

    @Autowired
    public final SeatDAO seatDAO;


    private Iterable<Seat> readBooking(LocalDate eventDate){

        return seatDAO.findAllByTicket_EventDate(eventDate);
    }

    @Cacheable(value= "statusCache", key= "#eventDate")
    public List<SeatDTO> getSeatDTOList(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("date") LocalDate eventDate) {
        System.out.println("Method getSeatDTOList() called");
        List<SeatDTO>  seatDTOlist = new ArrayList<>();
        readBooking(eventDate)
                .forEach(seatBooking -> seatDTOlist.add(new SeatDTO(
                        seatBooking.getId(),
                        seatBooking.getTicket()!= null ? seatBooking.getTicket().getPhoneNumber() : null,
                        seatBooking.getTicket().getPhoneNumber()!= null)));
        return seatDTOlist;
    }
}
