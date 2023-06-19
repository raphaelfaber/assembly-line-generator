package raphael.business;

import junit.framework.TestCase;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainProcessTest extends TestCase {
    final Path ASSEMBLY_LINE_TEST_INPUT_DATA_FILE = Paths.get( System.getProperty("user.dir") +"/src/input-test.txt");
    public void testIfOutputIsNotNull(){
        String output = MainProcess.run(ASSEMBLY_LINE_TEST_INPUT_DATA_FILE);
        assertNotNull(output);
    }
    public void testIfOutputIsNotBlank(){
        String output = MainProcess.run(ASSEMBLY_LINE_TEST_INPUT_DATA_FILE);
        assertTrue( !"".equals(output.trim()));
    }
    public void testIfOutputIsAsExpected(){
        String expectedOutput = "Assembly Line 1:\n" +
                "09:00 Cutting of steel sheets 60min\n" +
                "10:00 Safety sensor assembly 60min\n" +
                "11:00 Injection subsystem assembly 60min\n" +
                "12:00 Lunch\n" +
                "13:00 Navigation subsystem assembly 60min\n" +
                "14:00 Torque converter subsystem calibration 60min\n" +
                "15:00 Tempering sub-zero (Heat treatment) 45min\n" +
                "15:45 Pieces washing 45min\n" +
                "16:30 Assembly line cooling \n" +
                "16:35 Labor Gymnastics\n" +
                "\n" +
                "Assembly Line 2:\n" +
                "09:00 Steel bearing assembly 45min\n" +
                "09:45 Nitriding process 45min\n" +
                "10:30 Setup of lock and control device 45min\n" +
                "11:15 Seal installation 45min\n" +
                "12:00 Lunch\n" +
                "13:00 Austenpera (Heat treatment) 30min\n" +
                "13:30 Axis calibration 30min\n" +
                "14:00 Compliance check 30min\n" +
                "14:30 Left stabilizer bar alignment 30min\n" +
                "15:00 Right stabilizer bar alignment 30min\n" +
                "15:30 Application of decals 30min\n" +
                "16:00 Monitoring subsystem assembly 30min\n" +
                "16:30 Labor Gymnastics\n" +
                "\n";
        String output = MainProcess.run(ASSEMBLY_LINE_TEST_INPUT_DATA_FILE);
        assertTrue(expectedOutput.trim().equals(output.trim()));
    }

}