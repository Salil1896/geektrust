package com.example.utils;

import com.example.models.Loan;
import com.example.models.LoanEMI;
import com.example.models.LoanPayment;
import com.example.models.LoanPaymentType;
import com.example.models.LumpSumPayment;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Double loanAmount = totalLoanAmount(loan);
        Map<Integer, List<LumpSumPayment>> emiIdVsLoanPayments =
                loanPayments.stream().filter(x -> LoanPaymentType.LUMP_SUM.equals(x.getType())).map(x -> (LumpSumPayment) x)
                        .collect(Collectors.groupingBy(LumpSumPayment::getEmiId));

        AtomicReference<Double> currentPayment = new AtomicReference<>(0.0);
        IntStream.range(1, emiId + 1).forEach(id -> {
            double emi = (double) loan.getEmi().getAmount();
            double paymentAfterEmi = currentPayment.get() + emi;
            if (Double.compare(paymentAfterEmi, loanAmount) > 0) {
                emi = loanAmount - currentPayment.get();
            }
            currentPayment.set(currentPayment.get() + Math.ceil(emi));

            if (emiIdVsLoanPayments.containsKey(id)) {
                currentPayment.set(currentPayment.get() +
                        emiIdVsLoanPayments.get(id).stream().map(LoanPayment::getAmount).reduce(0.0, Double::sum));
            }
        });

        return (int) Math.ceil(currentPayment.get());
    }

    public static Integer emiLeft(Loan loan, Integer balancePayment) {
        Double amountLeft = totalLoanAmount(loan) - balancePayment;
        if (amountLeft <= 0.0) return 0;
        return (int) Math.ceil((double) amountLeft / loan.getEmi().getAmount());
    }

}
