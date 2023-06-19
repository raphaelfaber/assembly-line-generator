package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.periods.AfternoonPeriod;
import raphael.entities.periods.LunchPeriod;
import raphael.entities.periods.MorningPeriod;

import java.util.ArrayList;

public class AssemblyLineGenerator {
    private ArrayList<String> nameOfAssemblyLinesToBeGenerated;

    public AssemblyLineGenerator(ArrayList<String> nameOfAssemblyLinesToBeGenerated) {
        this.nameOfAssemblyLinesToBeGenerated = nameOfAssemblyLinesToBeGenerated;
    }

    public ArrayList<AssemblyLine> generate(ArrayList<AssemblyLineActivity> listOfActivitiesSortedByDuration){
        ArrayList<AssemblyLine> assemblyLinesGenerated = new ArrayList<AssemblyLine>();
        for(String assemblyLineName : nameOfAssemblyLinesToBeGenerated)
        {
            AssemblyLine assemblyLine = new AssemblyLine(assemblyLineName);

            assemblyLine.initializeTimeCountInMinutes(MorningPeriod.MORNING_START_TIME_IN_MINUTES);

            MorningPeriod morning = AssemblyLineMorningPeriodGenerator.generate(listOfActivitiesSortedByDuration,assemblyLine.getElapsedProductionTimeInMinutes());
            assemblyLine.assignActivitiesToAssemblyLine(morning.getActivities());
            assemblyLine.countElapsedTime();

            LunchPeriod lunch = AssemblyLineLunchPeriodGenerator.generate(assemblyLine.getElapsedProductionTimeInMinutes());
            assemblyLine.assignActivitiesToAssemblyLine(lunch.getActivities());
            assemblyLine.countElapsedTime();

            AfternoonPeriod afternoon = AssemblyLineAfternoonPeriodGenerator.generate(listOfActivitiesSortedByDuration,assemblyLine.getElapsedProductionTimeInMinutes());
            assemblyLine.assignActivitiesToAssemblyLine(lunch.getActivities());
            assemblyLine.countElapsedTime();

            assemblyLine.setAfternoonPeriod(afternoon);
            assemblyLine.setMorningPeriod(morning);
            assemblyLine.setLunchPeriod(lunch);

            assemblyLinesGenerated.add(assemblyLine);
        }

        return assemblyLinesGenerated;
    }
}
