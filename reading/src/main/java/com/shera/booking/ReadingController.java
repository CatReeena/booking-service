package com.shera.booking;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReadingController {

    @Autowired
    public final ReadingService readingService;


    @GetMapping("/status")
    public ResponseEntity<?> readSeatStatus(@RequestParam("date")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eventDate){

        List<SeatDTO> seatDTOlist = readingService.getSeatDTOList(eventDate);
        return ResponseEntity.ok().body(seatDTOlist);
    }


}
