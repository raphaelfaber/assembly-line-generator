package raphael.utilities.timemanager;

import java.time.LocalTime;

public class TimeConversion {
    public static int convertTimeInMinutes(int hours, int minutes){
        return LocalTime.of(hours,minutes).toSecondOfDay()/60;
    }
}
