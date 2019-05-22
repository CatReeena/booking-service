package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.dao.TicketDAO;
import com.shera.booking.entity.Seat;
import com.shera.booking.entity.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
@AllArgsConstructor
public class BookingCache {

    @Autowired
    public final TicketDAO ticketDAO;


    @Cacheable(value= "bookingCache", key= "{#seat.id, #date}")
    public Ticket findTicket(Seat seat, LocalDate date){
        System.out.println("Method findTicket called");
        return ticketDAO.findFirstBySeatAndEventDate(seat, date);
    }

    @CachePut(value= "bookingCache", key= "{#ticket.seat.id, #ticket.eventDate}")
    public Ticket updateTicket(Ticket ticket){
        System.out.println("Method updateTicket called");
        return ticketDAO.save(ticket);
    }
}
