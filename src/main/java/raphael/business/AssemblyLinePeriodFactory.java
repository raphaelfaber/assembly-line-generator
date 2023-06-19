package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.periods.AfternoonPeriod;
import raphael.entities.periods.LunchPeriod;
import raphael.entities.periods.MorningPeriod;
import raphael.interfaces.PeriodEstimable;

import java.util.ArrayList;

public class AssemblyLinePeriodFactory {
    public static PeriodEstimable create(AssemblyLine assemblyLine, ArrayList<AssemblyLineActivity> listOfActivitiesSortedByDuration){
        if(assemblyLine.getElapsedProductionTimeInMinutes() == MorningPeriod.MORNING_START_TIME_IN_MINUTES) {
            return AssemblyLineMorningPeriodGenerator.generate( listOfActivitiesSortedByDuration , assemblyLine.getElapsedProductionTimeInMinutes());
        } else if (assemblyLine.getElapsedProductionTimeInMinutes() == LunchPeriod.LUNCH_START_TIME_IN_MINUTES) {
            return AssemblyLineLunchPeriodGenerator.generate( assemblyLine.getElapsedProductionTimeInMinutes());
        } else if (assemblyLine.getElapsedProductionTimeInMinutes() == AfternoonPeriod.AFTERNOON_START_TIME_IN_MINUTES){
            return (AssemblyLineAfternoonPeriodGenerator.generate(listOfActivitiesSortedByDuration , assemblyLine.getElapsedProductionTimeInMinutes()));
        } else return null;
    }
}
