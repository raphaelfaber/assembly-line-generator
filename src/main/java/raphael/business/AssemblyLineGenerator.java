package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.entities.activities.AssemblyLineActivity;
import raphael.entities.periods.AfternoonPeriod;
import raphael.entities.periods.LunchPeriod;
import raphael.entities.periods.MorningPeriod;
import raphael.interfaces.PeriodEstimable;

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
            PeriodEstimable period = null;
            do{
                period = AssemblyLinePeriodFactory.create(assemblyLine,listOfActivitiesSortedByDuration);
                if (period == null){
                    break;
                }
                if(MorningPeriod.IDENTIFICATION.equals(period.getPeriodIdentification())){
                    assemblyLine.setMorningPeriod((MorningPeriod) period);
                }else if(LunchPeriod.IDENTIFICATION.equals(period.getPeriodIdentification())){
                    assemblyLine.setLunchPeriod((LunchPeriod) period);
                }else if(AfternoonPeriod.IDENTIFICATION.equals(period.getPeriodIdentification())){
                    assemblyLine.setAfternoonPeriod((AfternoonPeriod) period);
                }
                assemblyLine.assignActivitiesToAssemblyLine(period.getActivities());
                assemblyLine.countElapsedTime();
            }while(period != null);
            assemblyLinesGenerated.add(assemblyLine);
        }

        return assemblyLinesGenerated;
    }
}
