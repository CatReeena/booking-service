package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class StoringConsumer {

    @Autowired
    public final StoringService storingService;

    @KafkaListener(topics = "queue")
    public void receiveFirstTopic(ConsumerRecord<String, BookingRequest> record) {
        log.info("[Topic {}] | Received message: key - {}, value - {}", record.topic(), record.key(), record.value());
        BookingRequest bookingRequest = record.value();
        storingService.storeBooking(bookingRequest);
    }

}
