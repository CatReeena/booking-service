package com.shera.storing.dao;

import com.shera.storing.entity.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingDAO extends CrudRepository<Booking, Long> {
    public Booking findFirstBySeatId(Long seatId);
}
