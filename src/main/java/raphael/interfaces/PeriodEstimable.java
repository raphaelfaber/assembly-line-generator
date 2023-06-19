package raphael.interfaces;

import java.util.ArrayList;

public interface PeriodEstimable {
    public boolean isOnPeriod(int elapsedTimeInMinutes);
    public boolean canActivityBeAdded(int elapsedTimeInMinutes,int activityDuration);
    public String getPeriodIdentification();
    public ArrayList<ActivityListable> getActivities();
}
