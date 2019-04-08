package com.shera.storing;

import com.shera.booking.BookingRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StoringConsumer {

    //@KafkaListener(topics = "queue")
    public BookingRequest receiveFirstTopic(ConsumerRecord<String, BookingRequest> record) {
        log.info("[Topic {}] | Received message: key - {}, value - {}", record.topic(), record.key(), record.value());
        BookingRequest bookingRequest = record.value();

        return bookingRequest;
    }

}
