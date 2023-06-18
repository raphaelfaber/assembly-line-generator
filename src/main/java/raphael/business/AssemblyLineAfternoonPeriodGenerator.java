package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.activities.IdleTime;
import raphael.entities.activities.LaborGymnastics;
import raphael.entities.periods.AfternoonPeriod;
import raphael.entities.periods.MorningPeriod;

import java.util.ArrayList;

public class AssemblyLineAfternoonPeriodGenerator {
    public static AfternoonPeriod generate(ArrayList<AssemblyLineActivity> activitiesList, int elapsedTimeInMinutes){
        AfternoonPeriod afternoonPeriod = new AfternoonPeriod();
        for(AssemblyLineActivity activity : activitiesList){
            if(afternoonPeriod.isOnPeriod(elapsedTimeInMinutes) && afternoonPeriod.canActivityBeAdded(elapsedTimeInMinutes,activity.getDurationInMinutes())){
                if(!activity.isThisActivityAlreadyAssigned()){
                    afternoonPeriod.getActivities().add(activity);
                    activity.assignThisActivity();
                    elapsedTimeInMinutes += activity.getDurationInMinutes();
                }
            }
        }
        if(afternoonPeriod.isOnPeriod(elapsedTimeInMinutes)){
            if(elapsedTimeInMinutes < LaborGymnastics.LABOR_GYM_MIN_START_TIME_IN_MINUTES){
                IdleTime idleTime = new IdleTime(elapsedTimeInMinutes, LaborGymnastics.LABOR_GYM_MIN_START_TIME_IN_MINUTES);
                afternoonPeriod.getActivities().add(idleTime);

                LaborGymnastics laborGymnastics = new LaborGymnastics(elapsedTimeInMinutes);
                afternoonPeriod.getActivities().add(laborGymnastics);
            }else{
                LaborGymnastics laborGymnastics = new LaborGymnastics(elapsedTimeInMinutes);
                afternoonPeriod.getActivities().add(laborGymnastics);
            }
        }
        return afternoonPeriod;
    }
}