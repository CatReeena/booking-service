package com.shera.booking.dao;

import com.shera.booking.entity.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingDAO extends CrudRepository<Booking, Long> {
    public Booking findFirstBySeatId(Long seatId);
}
