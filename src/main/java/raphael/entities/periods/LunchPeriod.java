package raphael.entities.periods;

import raphael.interfaces.ActivityListable;
import raphael.utilities.timemanager.TimeConversion;

public class LunchPeriod implements ActivityListable {
    public static final int LUNCH_START_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(12,0);
    public static final int LUNCH_END_TIME_IN_MINUTES = TimeConversion.convertTimeInMinutes(13,0);
    public static final String LUNCH_ACTIVITY_DESCRIPTION = "Almoço";
    @Override
    public int getDurationInMinutes() {
        return LUNCH_END_TIME_IN_MINUTES - LUNCH_START_TIME_IN_MINUTES;
    }

    @Override
    public String getDescription() {
        return LUNCH_ACTIVITY_DESCRIPTION;
    }

}
