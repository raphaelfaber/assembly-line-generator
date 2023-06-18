package raphael.business;

import raphael.entities.AssemblyLine;

import java.util.ArrayList;

public class FormatOutput {
    ArrayList<AssemblyLine> assemblyLines;
    public FormatOutput(ArrayList<AssemblyLine> assemblyLines){
        this.assemblyLines = assemblyLines;
    }
    public void process(){
        for(AssemblyLine assemblyLine: assemblyLines){
            System.out.println("nome:"+assemblyLine.getAssemblyLineName());
            assemblyLine.getMorningPeriod().getActivities().forEach( activityListable -> {
                System.out.println(activityListable.getDurationInMinutes() + " " + activityListable.getDescription());
            });
        }
    }
}
