package com.example;

import com.example.utils.CommandUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class Geektrust {

    public static void main(String[] args) throws IOException {
        String filePath = args[0];

        FileInputStream fileStream = new FileInputStream(filePath);

        List<String> inputLines = CommandUtils.readInputStream(fileStream);
        CommandUtils.processInputCommands(inputLines);
        fileStream.close();
    }
}