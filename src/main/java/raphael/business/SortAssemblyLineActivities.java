package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortAssemblyLineActivities {
    public static ArrayList<AssemblyLineActivity> sortByDescendingDuration(ArrayList<AssemblyLineActivity> unsortedList){
        ArrayList<AssemblyLineActivity> sortedList = new ArrayList<AssemblyLineActivity>(unsortedList);
        Collections.sort(sortedList, Comparator.comparingInt(AssemblyLineActivity::getDurationInMinutes));
        return sortedList;
    }
}
