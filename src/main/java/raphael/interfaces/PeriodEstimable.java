package raphael.interfaces;

public interface PeriodEstimable {
    public boolean isOnPeriod(int elapsedTimeInMinutes);
    public boolean canActivityBeAdded(int elapsedTimeInMinutes,int activityDuration);
}
