package com.shera.booking;

import com.shera.booking.dao.BookingDAO;
import com.shera.booking.dao.SeatDAO;
import com.shera.booking.entity.Booking;
import com.shera.booking.entity.Seat;
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
