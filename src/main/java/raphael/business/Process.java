package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.utilities.filemanager.AssemblyLineFileInputReader;

import java.util.ArrayList;

public class Process {
    public static boolean run(){
        ArrayList<String> linesFromInputFile = AssemblyLineFileInputReader.readFile();
        ArrayList<AssemblyLineActivity> assemblyLineActivitiesList = ExtractAssemblyLineActivitiesFromInput.extract(linesFromInputFile);
        ArrayList<AssemblyLineActivity> assemblyLineActivitiesListSortedByDuration = SortAssemblyLineActivities.sortByDescendingDuration(assemblyLineActivitiesList);
        return true;
    }
}
