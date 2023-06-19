package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.periods.LunchPeriod;
import raphael.utilities.logs.AssemblyLineLog;

import java.util.ArrayList;

public class AssemblyLineLunchPeriodGenerator{
    public static LunchPeriod generate(int elapsedTimeInMinutes){
        LunchPeriod lunch = new LunchPeriod();
        if(!lunch.isOnPeriod(elapsedTimeInMinutes)
                || !lunch.canActivityBeAdded(elapsedTimeInMinutes,lunch.getDurationInMinutes())){
            AssemblyLineLog.error("Error while generating Lunch Period.");
            throw new RuntimeException("Morning Period got compromised.");
        }
        return lunch;
    }
}
