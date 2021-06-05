package com.example.utils;

import com.example.models.Loan;
import com.example.models.LoanEMI;
import com.example.models.LoanPayment;
import com.example.models.LoanPaymentType;
import com.example.models.LumpSumPayment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class LoanUtils {

    public static Double totalLoanAmount(Loan loan) {
        return loan.getAmount() + ((loan.getAmount() * loan.getInterestRate() * loan.getYears()) / 100.0);
    }

    public static LoanEMI loanEmi(Loan loan) {
        return new LoanEMI((int) Math.ceil(totalLoanAmount(loan) / (12 * loan.getYears())));
    }

    public static Integer balancePayment(Loan loan, List<LoanPayment> loanPayments, Integer emiId) {
        Integer emiAmount = loan.getEmi().getAmount() * emiId;
        Integer lumpSumAmount = (int) Math.ceil(loanPayments.stream()
                .filter(x -> LoanPaymentType.LUMP_SUM.equals(x.getType()))
                .filter(x -> ((LumpSumPayment) x).getEmiId() <= emiId)
                .collect(Collectors.toList()).stream().map(LoanPayment::getAmount).reduce(0.0, Double::sum));

        return emiAmount + lumpSumAmount;
    }

    public static Integer emiLeft(Loan loan, Integer balancePayment) {
        Double amountLeft = totalLoanAmount(loan) - balancePayment;
        return (int) Math.ceil((double) amountLeft / loan.getEmi().getAmount());
    }

}
