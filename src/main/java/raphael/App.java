package raphael;

import raphael.business.MainProcess;
import raphael.utilities.logs.AssemblyLineLog;

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
        if(!MainProcess.run()){
            AssemblyLineLog.error("Houve um erro durante o processamento. Finalizando...");
        }

    }
}
