package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.entities.activities.AssemblyLineActivity;
import raphael.utilities.filemanager.AssemblyLineFileInputReader;

import java.util.ArrayList;

public class MainProcess {
    public static boolean run(){
        ArrayList<String> linesFromInputFile = AssemblyLineFileInputReader.readFile();
        ArrayList<AssemblyLineActivity> activitiesList = ExtractAssemblyLineActivitiesFromInput.extract(linesFromInputFile);
        ArrayList<AssemblyLineActivity> activitiesListSortedByDuration = SortAssemblyLineActivities.sortByDescendingDuration(activitiesList);
        AssemblyLineGenerator assemblyLinesGenerator = new AssemblyLineGenerator(AssemblyLine.getAllNames());
        ArrayList<AssemblyLine> assemblyLines = assemblyLinesGenerator.generate(activitiesListSortedByDuration);
        ProcessAssemblyLineOutput outputTextGenerator =  new ProcessAssemblyLineOutput(assemblyLines);
        String outputText = outputTextGenerator.process();
        System.out.print(outputText);
        return true;
    }
}
