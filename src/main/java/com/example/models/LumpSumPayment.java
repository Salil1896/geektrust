package com.example.models;


public class LumpSumPayment extends LoanPayment {
    private String bankName;
    private String borrowerName;
    private Integer emiId;

    public LumpSumPayment(String bankName, String borrowerName, Double amount, Integer emiId) {
        super(LoanPaymentType.LUMP_SUM, amount);
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiId = emiId;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setEmiId(Integer emiId) {
        this.emiId = emiId;
    }

    public Integer getEmiId() {
        return emiId;
    }
}

