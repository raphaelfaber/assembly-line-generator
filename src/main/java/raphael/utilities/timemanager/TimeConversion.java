package raphael.utilities.timemanager;

import java.time.LocalTime;

public class TimeConversion {
    public static int convertTimeInMinutes(int hours, int minutes){
        return LocalTime.of(hours,minutes).toSecondOfDay()/60;
    }

    public static String getTimeFormated(int elapsedMinutes){
        int hours = elapsedMinutes/60;
        int minutes = elapsedMinutes - (hours*60);
        return (String.format("%02d:%02d",hours,minutes));
    }
}
