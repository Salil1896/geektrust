package com.example.models;


public class Loan {
    private String bankName;
    private String borrowerName;
    private Integer years;
    private Double interestRate;
    private LoanEMI emi;
    private Double amount;

    public Loan(String bankName, String borrowerName, Double amount, Integer years, Double interestRate) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.years = years;
        this.interestRate = interestRate;
        this.amount = amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public String getBankName() {
        return bankName;
    }

    public Integer getYears() {
        return years;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setEmi(LoanEMI emi) {
        this.emi = emi;
    }

    public LoanEMI getEmi() {
        return emi;
    }

    public Double getAmount() {
        return amount;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
