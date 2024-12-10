package com.example.searchapi.controllers;

import com.example.searchapi.model.Claim;
import com.example.searchapi.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    @PreAuthorize("hasRole ('user')")
    public Iterable<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole ('user')")
    public Optional<Claim> getClaimById(@PathVariable("id") String claimId) {
        return claimService.getClaimById(claimId);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole ('user')")
    public ResponseEntity<Claim> updateClaim(@PathVariable String id, @RequestBody Claim claimDetails) {
        Claim updatedClaim = claimService.updateClaim(id, claimDetails);
        return ResponseEntity.ok(updatedClaim);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole ('user')")
    public ResponseEntity<String> deleteClaim(@PathVariable("id") String claimId) {
        try {
            claimService.deleteClaim(claimId);
            return ResponseEntity.ok("Réclamation supprimée avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de la suppression de la réclamation.");
        }
    }

}
