package com.example.service;

import com.example.elasticsearch.Claim;
import com.example.kafka.ClaimRequest;
import com.example.repository.ClaimRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClaimConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ClaimConsumer.class);

    @Autowired
    private ClaimRepository claimRepository;

    @KafkaListener(topics = "claims_topic", groupId = "group_id")
    public void consume(ClaimRequest claimRequest) {
        logger.info("Consumed message: " + claimRequest);

        // Convertir ClaimRequest en Claim pour Elasticsearch
        Claim claim = new Claim(
                claimRequest.getClaimId(),
                claimRequest.getCustomerName(),
                claimRequest.getClaimType(),
                claimRequest.getClaimDescription(),
                claimRequest.getEmail(),"non traité"
        );

        claimRepository.save(claim);

        logger.info("Persisted claim: " + claim);
    }
}
