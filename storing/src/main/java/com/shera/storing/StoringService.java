package com.shera.storing;

import com.shera.booking.BookingRequest;
import com.shera.storing.dao.BookingDAO;
import com.shera.storing.dao.SeatDAO;
import com.shera.storing.entity.Booking;
import com.shera.storing.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoringService {

    @Autowired
    public final BookingDAO bookingDAO;

    @Autowired
    public final SeatDAO seatDAO;

    public void storeBooking(BookingRequest bookingRequest){

        Seat seat = seatDAO.findById(bookingRequest.getSeat()).orElse(null);
        if(seat != null) {
            if (bookingDAO.findFirstBySeatId(seat.getId()) == null) {
                bookingDAO.save(new Booking(seat, bookingRequest.getPhoneNumber())); 
            }
        }
    }
}
