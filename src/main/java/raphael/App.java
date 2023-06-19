package raphael;

import raphael.business.MainProcess;

import java.time.LocalTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started");
        System.out.println( "Generating output...");
        MainProcess.run();

    }
}
