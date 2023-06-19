package raphael;

import raphael.business.MainProcess;
import raphael.utilities.filemanager.AssemblyLineFileInputReader;
import raphael.utilities.logs.AssemblyLineLog;

import java.nio.file.Path;
import java.nio.file.Paths;

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
        Path input = Paths.get(AssemblyLineFileInputReader.pathOrigin);
        String output = MainProcess.run(input);
        System.out.println(output);

    }
}
