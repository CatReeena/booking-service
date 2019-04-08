package com.shera.storing;

import org.springframework.data.repository.CrudRepository;

public interface SeatDAO extends CrudRepository<Booking, Long>  {
}
