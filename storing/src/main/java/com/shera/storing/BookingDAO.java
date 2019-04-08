package com.shera.storing;

import org.springframework.data.repository.CrudRepository;

public interface BookingDAO extends CrudRepository<Booking, Long> {
}
