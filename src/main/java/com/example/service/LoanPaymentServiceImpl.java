package com.example.service;


import com.example.models.LoanPayment;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class LoanPaymentServiceImpl implements LoanPaymentService {

    private LoanStorageManager loanStorageManager;

    public LoanPaymentServiceImpl(LoanStorageManager loanStorageManager) {
        this.loanStorageManager = loanStorageManager;
    }


    @Override
    public void addLoanPayment(LoanPayment loanPayment) {
        loanStorageManager.addLoanPayment(loanPayment);
    }
}
