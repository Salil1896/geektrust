package com.example.service;


import com.example.models.Loan;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class LoanServiceImpl implements LoanService {

    private LoanStorageManager loanStorageManager;

    public LoanServiceImpl(LoanStorageManager loanStorageManager) {
        this.loanStorageManager = loanStorageManager;
    }


    @Override
    public void addLoan(Loan loan) {
        loanStorageManager.addLoan(loan);
    }
}
