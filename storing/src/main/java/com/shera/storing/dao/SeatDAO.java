package com.shera.storing.dao;

import com.shera.storing.entity.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatDAO extends CrudRepository<Seat, Long>  {
}
