package com.shera.booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private final BookingProducer bookingProducer;

    public BookingController(BookingProducer bookingProducer) {
        this.bookingProducer = bookingProducer;
    }

    @RequestMapping("/test")
    public String test(){
        return "Hi there";
    }

    @PostMapping("/booking")
    public ResponseEntity<?> tryToBook(@RequestBody BookingRequest bookingRequest){
        bookingProducer.send("queue", bookingRequest);
        return ResponseEntity.ok().build();
    }
}
