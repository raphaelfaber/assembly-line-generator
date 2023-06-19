package raphael.entities.activities;

import raphael.interfaces.ActivityListable;
import raphael.utilities.timemanager.TimeConversion;

public class LaborGymnastics implements ActivityListable {

    private final int durationInMinutes;
    public static final int LABOR_GYM_MIN_START_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(16,0);
    public static final int LABOR_GYM_MAX_END_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(17,0);
    public static final String LABOR_GYM_DESCRIPTION = "Ginástica laboral";
    public LaborGymnastics(int startTimeInMinutes){
        this.durationInMinutes = LABOR_GYM_MAX_END_TIME_IN_MINUTES - startTimeInMinutes;
    }
    @Override
    public int getDurationInMinutes() {
        return this.durationInMinutes;
    }

    @Override
    public String getDescription() {
        return LABOR_GYM_DESCRIPTION;
    }
}
