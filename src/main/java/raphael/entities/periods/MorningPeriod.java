package raphael.entities.periods;

import raphael.interfaces.ActivityListable;
import raphael.interfaces.PeriodEstimable;
import raphael.utilities.timemanager.TimeConversion;

import java.util.ArrayList;

public class MorningPeriod implements PeriodEstimable {
    public static final int MORNING_START_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(9,0);
    public static final int MORNING_END_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(12,0);
    private ArrayList<ActivityListable> activities = new ArrayList<ActivityListable>();
    public ArrayList<ActivityListable> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<ActivityListable> activities) {
        this.activities = activities;
    }
    @Override
    public boolean isOnPeriod(int elapsedTimeInMinutes) {
        return  elapsedTimeInMinutes >= MORNING_START_TIME_IN_MINUTES && elapsedTimeInMinutes < MORNING_END_TIME_IN_MINUTES;
    }
    @Override
    public boolean canActivityBeAdded(int elapsedTimeInMinutes,int activityDuration) {
        return elapsedTimeInMinutes + activityDuration < MORNING_END_TIME_IN_MINUTES;
    }
}
