package com.example.service;

import com.example.models.Loan;
import com.example.models.LoanPayment;
import com.example.models.LumpSumPayment;
import com.example.utils.LoanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class LoanStorageManager {
    private Map<String, Map<String, Loan>> bankUserVsLoan;
    private Map<String, Map<String, List<LoanPayment>>> bankUserVsLoanPayment;

    public LoanStorageManager() {
        bankUserVsLoan = new HashMap<>();
        bankUserVsLoanPayment = new HashMap<>();
    }

    public void addLoan(Loan loan) {
        if (Objects.isNull(bankUserVsLoan.get(loan.getBankName()))) {
            bankUserVsLoan.put(loan.getBankName(), new HashMap<>());
        }
        loan.setEmi(LoanUtils.loanEmi(loan));
        bankUserVsLoan.get(loan.getBankName()).put(loan.getBorrowerName(), loan);
    }

    public Loan getLoan(String bankName, String borrowerName) {
        return bankUserVsLoan.get(bankName).get(borrowerName);
    }

    public void addLoanPayment(LoanPayment loanPayment) {
        switch (loanPayment.getType()) {
            case LUMP_SUM:
                LumpSumPayment lumpSumPayment = (LumpSumPayment) loanPayment;
                if (Objects.isNull(bankUserVsLoanPayment.get(lumpSumPayment.getBankName()))) {
                    bankUserVsLoanPayment.put(lumpSumPayment.getBankName(), new HashMap<>());
                }

                if (Objects.isNull(bankUserVsLoanPayment.get(lumpSumPayment.getBankName()).get(lumpSumPayment.getBorrowerName()))) {
                    bankUserVsLoanPayment.get(lumpSumPayment.getBankName()).put(lumpSumPayment.getBorrowerName(), new ArrayList<>());
                }

                bankUserVsLoanPayment.get(lumpSumPayment.getBankName()).get(lumpSumPayment.getBorrowerName()).add(loanPayment);
                break;

            default:
                break;
        }
    }

    public List<LoanPayment> getLoanPayment(String bankName, String borrowerName) {
        if (Objects.isNull(bankUserVsLoanPayment.get(bankName)) ||
                Objects.isNull(bankUserVsLoanPayment.get(bankName).get(borrowerName))) return Collections.emptyList();
        return bankUserVsLoanPayment.get(bankName).get(borrowerName);
    }

}
