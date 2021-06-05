package com.example.models;


public class LoanCommandData {
    private CommandType commandType;
    private String[] inputData;

    public LoanCommandData(CommandType commandType, String[] inputData) {
        this.commandType = commandType;
        this.inputData = inputData;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public String[] getInputData() {
        return inputData;
    }

    public void setInputData(String[] inputData) {
        this.inputData = inputData;
    }
}
