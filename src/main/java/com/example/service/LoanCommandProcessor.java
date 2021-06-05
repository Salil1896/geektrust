package com.example.service;

import com.example.models.CommandType;
import com.example.models.Loan;
import com.example.models.LoanBalance;
import com.example.models.LoanCommandData;
import com.example.models.LumpSumPayment;

public class LoanCommandProcessor extends CommandProcessor<LoanCommandData, Void> {

    private LoanStorageManager loanStorageManager;
    private LoanService loanService;
    private LoanBalanceService loanBalanceService;
    private LoanPaymentService loanPaymentService;

    public LoanCommandProcessor() {
        this.loanStorageManager = new LoanStorageManager();
        this.loanService = new LoanServiceImpl(loanStorageManager);
        this.loanBalanceService = new LoanBalanceServiceImpl(loanStorageManager);
        this.loanPaymentService = new LoanPaymentServiceImpl(loanStorageManager);

    }

    @Override
    public Void run(LoanCommandData data) {
        return data.getCommandType().accept(new CommandType.CommandTypeVisitor<Void>() {
            @Override
            public Void visitBalance() {
                String[] inputData = data.getInputData();
                LoanBalance loanBalance = loanBalanceService.getLoanBalance(inputData[1], inputData[2], Integer.valueOf(inputData[3]));
                System.out.println(loanBalance.getBankName() + " " +
                        loanBalance.getBorrowerName() + " " +
                        loanBalance.getAmount() + " " +
                        loanBalance.getEmiLeft());
                return null;
            }

            @Override
            public Void visitLoan() {
                String[] inputData = data.getInputData();
                loanService.addLoan(
                        new Loan(inputData[1], inputData[2],
                                Double.parseDouble(inputData[3]),
                                Integer.valueOf(inputData[4]),
                                Double.parseDouble(inputData[5]))
                );
                return null;
            }

            @Override
            public Void visitPayment() {
                String[] inputData = data.getInputData();
                loanPaymentService.addLoanPayment(
                        new LumpSumPayment(inputData[1], inputData[2], Double.parseDouble(inputData[3]), Integer.valueOf(inputData[4])));
                return null;
            }
        });
    }
}
