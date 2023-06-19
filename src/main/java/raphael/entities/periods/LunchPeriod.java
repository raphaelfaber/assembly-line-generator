package raphael.entities.periods;

import raphael.interfaces.ActivityListable;
import raphael.interfaces.PeriodEstimable;
import raphael.utilities.timemanager.TimeConversion;

import java.util.ArrayList;

public class LunchPeriod implements ActivityListable, PeriodEstimable {
    public static final String IDENTIFICATION = "Lunch period";
    public static final int LUNCH_START_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(12,0);
    public static final int LUNCH_END_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(13,0);
    public static final String LUNCH_ACTIVITY_DESCRIPTION = "Lunch";

    ArrayList<ActivityListable> activities;

    public LunchPeriod(){
        activities = new ArrayList<ActivityListable>();
        activities.add(this);
    }
    @Override
    public int getDurationInMinutes() {
        return LUNCH_END_TIME_IN_MINUTES - LUNCH_START_TIME_IN_MINUTES;
    }

    @Override
    public String getDescription() {
        return LUNCH_ACTIVITY_DESCRIPTION;
    }

    @Override
    public boolean isOnPeriod(int elapsedTimeInMinutes) {
        return elapsedTimeInMinutes >= LUNCH_START_TIME_IN_MINUTES &&  elapsedTimeInMinutes<=LUNCH_END_TIME_IN_MINUTES ;
    }

    @Override
    public boolean canActivityBeAdded(int elapsedTimeInMinutes, int activityDuration) {
        return elapsedTimeInMinutes + getDurationInMinutes() <= LUNCH_END_TIME_IN_MINUTES;
    }

    @Override
    public String getPeriodIdentification() {
        return IDENTIFICATION;
    }

    public  ArrayList<ActivityListable> getActivities(){
        return this.activities;
    }
}
