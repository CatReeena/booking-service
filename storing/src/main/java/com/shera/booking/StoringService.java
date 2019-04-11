package com.shera.booking;

import com.shera.booking.dao.TicketDAO;
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

    public void storeBooking(BookingRequest bookingRequest){
        Date d=  bookingRequest.getEventDate();
        Ticket ticket = ticketDAO.findFirstBySeatIdAndEventDate(bookingRequest.getSeatId(), bookingRequest.getEventDate());
        if(ticket != null){
            if (ticket.getPhoneNumber()!=null){
                ticket.setPhoneNumber(bookingRequest.getPhoneNumber());
                ticketDAO.save(ticket);
            }
        }
    }

}
