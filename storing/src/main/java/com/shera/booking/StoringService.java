package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.dao.TicketDAO;
import com.shera.booking.entity.Seat;
import com.shera.booking.entity.Ticket;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            Ticket ticket = findTicket(seat, bookingRequest.getEventDate());
            if (ticket != null) {
                if (ticket.getPhoneNumber() == null) {
                    ticket.setPhoneNumber(bookingRequest.getPhoneNumber());
                    updateTicket(ticket);
                }
            }
        }
    }

    //@Cacheable(value= "bookingCache", key= "{#seat.id, #date}")
    @Cacheable(value= "bookingCache", key= "#seat.id")
    public Ticket findTicket(Seat seat, LocalDate date){
        System.out.println("Method findTicket called");
        return ticketDAO.findFirstBySeatAndEventDate(seat, date);
    }

    //@CachePut(value= "bookingCache", key= "{#ticket.seat.id, ticket.eventDate}")
    @CachePut(value= "bookingCache", key= "#ticket.seat.id")
    public Ticket updateTicket(Ticket ticket){
        System.out.println("Method updateTicket called");
        return ticketDAO.save(ticket);
    }


}
