package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.activities.IdleTime;
import raphael.entities.periods.MorningPeriod;

import java.util.ArrayList;

public class AssemblyLineMorningPeriodGenerator {
    public static MorningPeriod generate(ArrayList<AssemblyLineActivity> activitiesList, int elapsedTimeInMinutes){
        MorningPeriod morning = new MorningPeriod();
        for(AssemblyLineActivity activity : activitiesList){
            if(morning.isOnPeriod(elapsedTimeInMinutes) && morning.canActivityBeAdded(elapsedTimeInMinutes,activity.getDurationInMinutes())){
                if(!activity.isThisActivityAlreadyAssigned()){
                    morning.getActivities().add(activity);
                    activity.assignThisActivity();
                    elapsedTimeInMinutes += activity.getDurationInMinutes();
                }
            }
        }
        if(morning.isOnPeriod(elapsedTimeInMinutes)){
            // if reach here, it means that there is no combination of activities that exactly fit in the morning
            IdleTime idleTime = new IdleTime(elapsedTimeInMinutes, MorningPeriod.MORNING_END_TIME_IN_MINUTES);
            morning.getActivities().add(idleTime);
        }
        return morning;
    }
}