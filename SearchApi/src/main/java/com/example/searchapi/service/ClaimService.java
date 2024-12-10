package com.example.searchapi.service;

import com.example.searchapi.model.Claim;
import com.example.searchapi.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Iterable<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(String claimId) {
        return claimRepository.findById(claimId);
    }

    public Claim updateClaim(String id, Claim claimDetails) {
        Claim existingClaim = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réclamation non trouvée"));
        existingClaim.setStatut(claimDetails.getStatut());

        return claimRepository.save(existingClaim);
    }

    @Transactional
    public void deleteClaim(String claimId) {
        if (claimRepository.existsById(claimId)) {
            claimRepository.deleteById(claimId);
        } else {
            throw new IllegalArgumentException("Réclamation avec ID " + claimId + " n'existe pas.");
        }
    }
}