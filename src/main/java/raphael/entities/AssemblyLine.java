package raphael.entities;

import raphael.entities.periods.AfternoonPeriod;
import raphael.entities.periods.LunchPeriod;
import raphael.entities.periods.MorningPeriod;
import raphael.interfaces.ActivityListable;
import java.util.ArrayList;
import java.util.UUID;

public class AssemblyLine {
    public static String FIRST_ASSEMBLY_LINE_NAME = "Linha de montagem 1";
    public static String SECOND_ASSEMBLY_LINE_NAME = "Linha de montagem 2";
    private String id;
    private String assemblyLineName;
    private MorningPeriod morningPeriod;

    public MorningPeriod getMorningPeriod() {
        return morningPeriod;
    }
    public String getAssemblyLineName() {
        return assemblyLineName;
    }
    public void setMorningPeriod(MorningPeriod morningPeriod) {
        this.morningPeriod = morningPeriod;
    }

    public LunchPeriod getLunchPeriod() {
        return lunchPeriod;
    }

    public void setLunchPeriod(LunchPeriod lunchPeriod) {
        this.lunchPeriod = lunchPeriod;
    }

    public AfternoonPeriod getAfternoonPeriod() {
        return afternoonPeriod;
    }

    public void setAfternoonPeriod(AfternoonPeriod afternoonPeriod) {
        this.afternoonPeriod = afternoonPeriod;
    }

    private LunchPeriod lunchPeriod;
    private AfternoonPeriod afternoonPeriod;
    private ArrayList<ActivityListable> allActivitiesInOrder;

    private int elapsedProductionTimeInMinutes;

    public int getStartProductionTimeInMinutes() {
        return startProductionTimeInMinutes;
    }

    private int startProductionTimeInMinutes;
    public AssemblyLine(String assemblyLineName){
        this.assemblyLineName = assemblyLineName;
        this.id = UUID.randomUUID().toString();
    }
    public int getElapsedProductionTimeInMinutes() {
        return elapsedProductionTimeInMinutes;
    }
    public void setElapsedProductionTime(int timeElapsedInThisStep){
        this.elapsedProductionTimeInMinutes = timeElapsedInThisStep;
    }
    public void initializeTimeCountInMinutes(int firstPeriodStartTimeInMinutes) {
        this.startProductionTimeInMinutes = firstPeriodStartTimeInMinutes;
        this.elapsedProductionTimeInMinutes = firstPeriodStartTimeInMinutes;
    }
    public static ArrayList<String> getAllNames(){
        ArrayList<String> assemblyLinesNames = new ArrayList<String>();
        assemblyLinesNames.add(FIRST_ASSEMBLY_LINE_NAME);
        assemblyLinesNames.add(SECOND_ASSEMBLY_LINE_NAME);
        return assemblyLinesNames;
    }
}
