package com.shera.booking.dao;

import com.shera.booking.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Date;

public interface TicketDAO extends CrudRepository<Ticket, Long> {

    public Ticket findFirstBySeatId(Long seatId);

    public Ticket findFirstBySeatIdAndEventDate(Long seatId, Date eventDate);
}
