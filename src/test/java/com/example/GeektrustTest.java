package com.example;

import com.example.utils.CommandUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public class GeektrustTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @Before
    public void beforeTest() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void afterTest() {
        System.setOut(null);
    }

    @Test
    public void Test1() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("input1.txt");
        List<String> inputLines = CommandUtils.readInputStream(inputStream);
        CommandUtils.processInputCommands(inputLines);

        String output = outputStream.toString();

        Assert.assertTrue((
                "IDIDI Dale 1000 55\n" +
                        "IDIDI Dale 8000 20\n" +
                        "MBI Harry 1044 12\n" +
                        "MBI Harry 0 24\n")
                .equals(output));
    }

    @Test
    public void Test2() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("input2.txt");
        List<String> inputLines = CommandUtils.readInputStream(inputStream);
        CommandUtils.processInputCommands(inputLines);

        String output = outputStream.toString();

        Assert.assertTrue((
                "IDIDI Dale 1326 9\n" +
                        "IDIDI Dale 3652 4\n" +
                        "UON Shelly 15856 3\n" +
                        "MBI Harry 9044 10\n")
                .equals(output));


    }
}
