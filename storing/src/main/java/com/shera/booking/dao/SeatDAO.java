package com.shera.booking.dao;

import com.shera.booking.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatDAO extends CrudRepository<Seat, Long>  {
}
