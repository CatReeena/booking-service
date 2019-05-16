package com.shera.booking;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRequestRepository extends CrudRepository<BookingRequest, String> {
}
