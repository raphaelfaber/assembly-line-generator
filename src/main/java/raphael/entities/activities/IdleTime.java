package raphael.entities.activities;

import raphael.interfaces.ActivityListable;

public class IdleTime implements ActivityListable {
    public static final String IDLE_TIME_DESCRIPTION = "Idle time";
    private int durationInMinutes;
    public IdleTime(int elapsedTimeInMinutes, int endOfCurrentPeriodInMinutes){
        durationInMinutes = endOfCurrentPeriodInMinutes - elapsedTimeInMinutes;
    }
    @Override
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String getDescription() {
        return IDLE_TIME_DESCRIPTION;
    }
}
