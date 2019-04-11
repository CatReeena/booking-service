package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Slf4j
@AllArgsConstructor
@Service
public class BookingProducer {

    private final KafkaTemplate<String, BookingRequest> kafkaTemplate;

    public void send(String topic, BookingRequest bookingRequest) {
        kafkaTemplate.send(topic, bookingRequest);
        log.info("[Topic {}] Message sent: phone: {}, seat: {}", topic,
                bookingRequest.getPhoneNumber(),
                bookingRequest.getSeatId());
    }
}
