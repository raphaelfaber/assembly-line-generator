package raphael.entities.periods;

import raphael.interfaces.ActivityListable;
import raphael.interfaces.PeriodEstimable;
import raphael.utilities.timemanager.TimeConversion;

import java.util.ArrayList;

public class AfternoonPeriod implements PeriodEstimable {
    public static final String IDENTIFICATION = "Afternoon period";
    public static final int AFTERNOON_START_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(13,0);
    public static final int AFTERNOON_END_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(17,0);

    public ArrayList<ActivityListable> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<ActivityListable> activities) {
        this.activities = activities;
    }

    private ArrayList<ActivityListable> activities = new ArrayList<ActivityListable>();
    @Override
    public boolean isOnPeriod(int elapsedTimeInMinutes) {
        return elapsedTimeInMinutes >= AFTERNOON_START_TIME_IN_MINUTES && elapsedTimeInMinutes < AFTERNOON_END_TIME_IN_MINUTES ;
    }
    @Override
    public boolean canActivityBeAdded(int elapsedTimeInMinutes,int activityDuration) {
        return elapsedTimeInMinutes + activityDuration < AFTERNOON_END_TIME_IN_MINUTES;
    }

    @Override
    public String getPeriodIdentification() {
        return IDENTIFICATION;
    }
}
