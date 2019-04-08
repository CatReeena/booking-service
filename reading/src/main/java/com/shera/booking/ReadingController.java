package com.shera.booking;

import com.google.common.collect.Lists;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReadingController {

    @Autowired
    public final ReadingService readingService;

    @GetMapping("/status")
    public ResponseEntity<?> readSeatStatus(){
        //return ResponseEntity.ok().body(readingService.readBooking().toString());
        List<Seat> seats =  Lists.newArrayList(readingService.readBooking());
        //return new ResponseEntity<Iterable<Seat>>(readingService.readBooking(), HttpStatus.OK);
        List<SeatDTO>  seatDTOlist = new ArrayList<>();
        readingService.readBooking()
                .forEach(seatBooking -> seatDTOlist.add(new SeatDTO(seatBooking.getId(),
                        seatBooking.getBooking().getPhoneNumber(),
                        seatBooking.getBooking()!= null)));

        return ResponseEntity.ok().body(seatDTOlist);
    }
}
