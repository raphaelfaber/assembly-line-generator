package raphael.utilities.filemanager;

import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AssemblyLineFileInputReaderTest extends TestCase {
    public void testIfInputFileExists(){
        assertTrue(Files.exists(Paths.get(AssemblyLineFileInputReader.pathOrigin)));
    }
    public void testIfReadMethodIsExtractingLines(){
        Path input = Paths.get(AssemblyLineFileInputReader.pathOrigin);
        ArrayList<String> lines = AssemblyLineFileInputReader.readFile(input);
        assertTrue(lines.size() > 0);
    }
}