package com.example.service;

import com.example.models.LoanBalance;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public interface LoanBalanceService {

    LoanBalance getLoanBalance(String bankName, String borrowerName, Integer emiId);
}
