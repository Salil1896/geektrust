package com.example.models;


public abstract class LoanPayment {
    private LoanPaymentType type;
    private Double amount;

    public LoanPayment(LoanPaymentType type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public LoanPaymentType getType() {
        return type;
    }

    public void setType(LoanPaymentType type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
