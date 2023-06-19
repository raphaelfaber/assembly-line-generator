package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.entities.activities.AssemblyLineActivity;
import raphael.utilities.filemanager.AssemblyLineFileInputReader;
import raphael.utilities.logs.AssemblyLineLog;

import java.nio.file.Path;
import java.util.ArrayList;

public class MainProcess {
    public static String run(Path input){

        try {
            ArrayList<String> linesFromInputFile = AssemblyLineFileInputReader.readFile(input);
            ArrayList<AssemblyLineActivity> activitiesList = ExtractAssemblyLineActivitiesFromInput.extract(linesFromInputFile);
            ArrayList<AssemblyLineActivity> activitiesListSortedByDuration = SortAssemblyLineActivities.sortByDescendingDuration(activitiesList);
            AssemblyLineGenerator assemblyLinesGenerator = new AssemblyLineGenerator(AssemblyLine.getAllNames());
            ArrayList<AssemblyLine> assemblyLines = assemblyLinesGenerator.generate(activitiesListSortedByDuration);
            ProcessAssemblyLineOutput outputTextGenerator = new ProcessAssemblyLineOutput(assemblyLines);
            return outputTextGenerator.process();
        }catch(Exception e){
            AssemblyLineLog.error(e.getMessage());
            return "Error on processing...";
        }

    }
}
