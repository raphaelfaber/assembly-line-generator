package raphael.business;

import junit.framework.TestCase;
import raphael.entities.activities.AssemblyLineActivity;

import java.util.ArrayList;

public class SortAssemblyLineActivitiesTest extends TestCase {
    public void testIfSortingIsFunctional(){
        AssemblyLineActivity firstOne = new AssemblyLineActivity(60,"First one when sorted");
        AssemblyLineActivity secondOne = new AssemblyLineActivity(50,"Second one when sorted");
        AssemblyLineActivity thirdOne = new AssemblyLineActivity(40,"Third one when sorted");
        AssemblyLineActivity fourthOne = new AssemblyLineActivity(30,"Fourth one when sorted");

        ArrayList<AssemblyLineActivity> referenceArray = new ArrayList<AssemblyLineActivity>();
        //preparing the reference array
        referenceArray.add(firstOne);
        referenceArray.add(secondOne);
        referenceArray.add(thirdOne);
        referenceArray.add(fourthOne);

        ArrayList<AssemblyLineActivity> testedArrayBeforeSort = new ArrayList<AssemblyLineActivity>();
        //Preparing test array without ordering it
        testedArrayBeforeSort.add(fourthOne);
        testedArrayBeforeSort.add(firstOne);
        testedArrayBeforeSort.add(thirdOne);
        testedArrayBeforeSort.add(secondOne);

        ArrayList<AssemblyLineActivity> testedArrayAfterSort = SortAssemblyLineActivities.sortByDescendingDuration(testedArrayBeforeSort);

        for(int i=0; i < referenceArray.size(); i++){
            if (!testedArrayAfterSort.get(i).getId().equals(referenceArray.get(i).getId()))
            {
                fail("Array was not sorted as expected");
            }
        }
    }

}