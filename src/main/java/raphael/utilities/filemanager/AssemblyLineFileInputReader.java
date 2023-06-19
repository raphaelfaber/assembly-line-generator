package raphael.utilities.filemanager;

import raphael.utilities.logs.AssemblyLineLog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AssemblyLineFileInputReader {
    static String pathOrigin = FilesPathConstants.ASSEMBLY_LINE_INPUT_DATA_FILE;
    public static ArrayList<String> readFile(){
        ArrayList<String> inputLines = getFileLines();
        return inputLines;
    }
    private static ArrayList<String> getFileLines(){
        Path path = Paths.get(pathOrigin);
        try {
            return new ArrayList<String>(Files.readAllLines(path));
        } catch (IOException e) {
            AssemblyLineLog.error("Erro ao ler arquivo "+ pathOrigin +".");
            throw new RuntimeException(e);
        }
    }
}
