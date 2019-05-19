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
    public final CacheClass cacheClass;

    @Autowired
    public final TicketDAO ticketDAO;

    @Autowired
    public final SeatDAO seatDAO;

    public void storeBooking(BookingRequest bookingRequest){

        cacheClass.findTicketById(1L);
        cacheClass.findTicketById(1L);

        Seat seat = seatDAO.findFirstById(bookingRequest.getSeatId());
        if(seat != null) {
            Ticket ticket = cacheClass.findTicket(seat, bookingRequest.getEventDate());
            if (ticket != null) {
                if (ticket.getPhoneNumber() == null) {
                    ticket.setPhoneNumber(bookingRequest.getPhoneNumber());
                    cacheClass.updateTicket(ticket);
                }
            }
        }
    }

    //@Cacheable(value= "bookingCache", key= "{#seat.id, #date}")



}
