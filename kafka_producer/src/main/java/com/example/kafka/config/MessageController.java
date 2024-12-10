package com.example.kafka.config;

import com.example.kafka.ClaimRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/claims")
public class MessageController {

    private KafkaTemplate<String, Object> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody ClaimRequest request) {
        kafkaTemplate.send("claims_topic", request);
    }
}
