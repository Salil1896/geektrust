package com.example.models;


public class LoanBalance {
    private String bankName;
    private String borrowerName;
    private Integer amount;
    private Integer emiLeft;

    public LoanBalance(String bankName, String borrowerName, Integer amount, Integer emiLeft) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.amount = amount;
        this.emiLeft = emiLeft;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getEmiLeft() {
        return emiLeft;
    }

    public void setEmiLeft(Integer emiLeft) {
        this.emiLeft = emiLeft;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
