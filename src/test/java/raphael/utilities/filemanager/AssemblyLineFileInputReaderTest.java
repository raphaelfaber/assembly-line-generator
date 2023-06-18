package raphael.utilities.filemanager;

import junit.framework.TestCase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AssemblyLineFileInputReaderTest extends TestCase {
    public void testIfInputFileExists(){
        assertTrue(Files.exists(Paths.get(AssemblyLineFileInputReader.pathOrigin)));
    }
    public void testIfReadMethodIsExtractingLines(){
        ArrayList<String> lines = AssemblyLineFileInputReader.readFile();
        assertTrue(lines.size() > 0);
    }
}