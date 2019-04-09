package com.shera.booking;

import com.google.common.collect.Lists;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReadingController {

    @Autowired
    public final ReadingService readingService;

    @GetMapping("/status")
    public ResponseEntity<?> readSeatStatus(@RequestParam("date")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eventDate){
        List<SeatDTO>  seatDTOlist = new ArrayList<>();
        readingService.readBooking(eventDate)
                .forEach(seatBooking -> seatDTOlist.add(new SeatDTO(
                        seatBooking.getId(),
                        seatBooking.getBooking()!= null ? seatBooking.getBooking().getPhoneNumber() : null,
                        seatBooking.getBooking().getPhoneNumber()!= null)));

        return ResponseEntity.ok().body(seatDTOlist);
    }
}
