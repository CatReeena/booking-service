package com.shera.booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Slf4j
public class BookingRequestDeserializer implements Deserializer<BookingRequest> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public BookingRequest deserialize(String topic, byte[] data) {
        BookingRequest purchase = null;
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        try {
            String json = new String(data, StandardCharsets.UTF_8);
            purchase = objectMapper.readValue(new String(data, StandardCharsets.UTF_8), BookingRequest.class);
        } catch (IOException e) {
            log.error("Unable to deserialize message {}", data, e);
        }

        return purchase;
    }

    @Override
    public void close() {
    }
}
