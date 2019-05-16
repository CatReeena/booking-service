package com.shera.booking;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BookingController {

    @Autowired
    private final BookingProducer bookingProducer;

    @Autowired
    private final BookingRequestRepository bookingRequestRepository;


    @RequestMapping("/test")
    public String test(){
        return "Hi there";
    }

    @PostMapping("/booking")
    public ResponseEntity<?> tryToBook(@RequestBody BookingRequest bookingRequest){

       //bookingRequestRepository.save(bookingRequest);
        //System.out.println(bookingRequestRepository.findAll());
        bookingProducer.send("queue", bookingRequest);
        return ResponseEntity.ok().build();
    }
}
