package com.example.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "claims")
public class Claim {

    @Id
    private String claimId;
    private String customerName;
    private String claimType;
    private String claimDescription;
    private String Email;
    private String statut;

    public Claim() {
    }

    // Constructeur avec paramètres
    public Claim(String claimId, String customerName, String claimType, String claimDescription, String email, String statut) {
        this.claimId = claimId;
        this.customerName = customerName;
        this.claimType = claimType;
        this.claimDescription = claimDescription;
        Email = email;
        this.statut = statut;
    }

    // Getters et setters
    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId='" + claimId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", claimType='" + claimType + '\'' +
                ", claimDescription='" + claimDescription + '\'' +
                ", Email='" + Email + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
