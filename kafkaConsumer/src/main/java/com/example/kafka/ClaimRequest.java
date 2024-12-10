package com.example.kafka;

public class ClaimRequest {
    private String claimId;
    private String customerName;
    private String claimType;
    private String claimDescription;
    private String email;


    // Constructeur par défaut requis pour la désérialisation
    public ClaimRequest() {
    }

    // Constructeur avec paramètres
    public ClaimRequest(String claimId, String customerName, String claimType, String claimDescription, String email) {
        this.claimId = claimId;
        this.customerName = customerName;
        this.claimType = claimType;
        this.claimDescription = claimDescription;

        this.email = email;
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
        return "ClaimRequest{" +
                "claimId='" + claimId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", claimType='" + claimType + '\'' +
                ", claimDescription='" + claimDescription + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
