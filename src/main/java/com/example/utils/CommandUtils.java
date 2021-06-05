package com.example.utils;

import com.example.models.CommandType;
import com.example.models.LoanCommandData;
import com.example.service.LoanCommandProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class CommandUtils {

    public static List<String> readInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String strLine;

        List<String> inputLines = new ArrayList<>();
        while ((strLine = br.readLine()) != null) {
            inputLines.add(strLine);
        }
        return inputLines;
    }

    public static void processInputCommands(List<String> inputCommands) {
        LoanCommandProcessor processor = new LoanCommandProcessor();
        inputCommands.forEach(line -> {
            String[] parts = line.split(" ");
            LoanCommandData commandData = new LoanCommandData(CommandType.valueOf(parts[0]), parts);
            processor.run(commandData);
        });
    }

}
