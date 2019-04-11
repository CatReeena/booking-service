package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.dao.TicketDAO;
import com.shera.booking.entity.Seat;
import com.shera.booking.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class StoringService {

    @Autowired
    public final TicketDAO ticketDAO;

    @Autowired
    public final SeatDAO seatDAO;

    public void storeBooking(BookingRequest bookingRequest){
        Seat seat = seatDAO.findFirstById(bookingRequest.getSeatId());
        if(seat != null) {
            Ticket ticket = ticketDAO.findFirstBySeatAndEventDate(seat, bookingRequest.getEventDate());
            if (ticket != null) {
                if (ticket.getPhoneNumber() != null) {
                    ticket.setPhoneNumber(bookingRequest.getPhoneNumber());
                    ticketDAO.save(ticket);
                }
            }
        }
    }

}
