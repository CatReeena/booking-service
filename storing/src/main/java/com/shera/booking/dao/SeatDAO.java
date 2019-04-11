package com.shera.booking.dao;

import com.shera.booking.entity.Seat;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SeatDAO extends CrudRepository<Seat, Long>  {

    public List<Seat> findAllByTicket_EventDate(LocalDate date);

    public Seat findFirstById(Long id);
}
