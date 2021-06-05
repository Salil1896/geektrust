package com.example.service;


import com.example.models.Loan;
import com.example.models.LoanBalance;
import com.example.models.LoanPayment;
import com.example.utils.LoanUtils;

import java.util.List;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class LoanBalanceServiceImpl implements LoanBalanceService {

    private LoanStorageManager loanStorageManager;

    public LoanBalanceServiceImpl(LoanStorageManager loanStorageManager) {
        this.loanStorageManager = loanStorageManager;
    }

    @Override
    public LoanBalance getLoanBalance(String bankName, String borrowerName, Integer emiId) {
        Loan loan = loanStorageManager.getLoan(bankName, borrowerName);
        List<LoanPayment> loanPayments = loanStorageManager.getLoanPayment(bankName, borrowerName);

        Integer balancePayment = LoanUtils.balancePayment(loan, loanPayments, emiId);
        Integer emiLeft = LoanUtils.emiLeft(loan, balancePayment);
        return new LoanBalance(bankName, borrowerName, balancePayment, emiLeft);
    }
}
