package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReadingService {

    @Autowired
    public final SeatDAO seatDAO;

    public Iterable<Seat> readBooking(){
        return seatDAO.findAll();
    }
}
