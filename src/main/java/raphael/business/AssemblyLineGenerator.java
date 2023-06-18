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
            LunchPeriod lunch = new LunchPeriod();
            assemblyLine.setElapsedProductionTime(AfternoonPeriod.AFTERNOON_START_TIME_IN_MINUTES);
            AfternoonPeriod afternoon = AssemblyLineAfternoonPeriodGenerator.generate(listOfActivitiesSortedByDuration,assemblyLine.getElapsedProductionTimeInMinutes());

            assemblyLine.setAfternoonPeriod(afternoon);
            assemblyLine.setMorningPeriod(morning);
            assemblyLine.setLunchPeriod(lunch);

            assemblyLinesGenerated.add(assemblyLine);
        }

        return assemblyLinesGenerated;
    }
}
