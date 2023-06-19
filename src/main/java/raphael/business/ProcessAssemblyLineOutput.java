package raphael.business;

import raphael.entities.AssemblyLine;
import raphael.interfaces.ActivityListable;
import raphael.utilities.timemanager.TimeConversion;

import java.util.ArrayList;

public class ProcessAssemblyLineOutput {
    ArrayList<AssemblyLine> assemblyLines;
    public ProcessAssemblyLineOutput(ArrayList<AssemblyLine> assemblyLines){
        this.assemblyLines = assemblyLines;
    }
    public String process(){
        StringBuffer output = new StringBuffer();
        for(AssemblyLine assemblyLine: assemblyLines){
            int elapsedTime = assemblyLine.getStartProductionTimeInMinutes();

            output.append(String.format("%s:",assemblyLine.getAssemblyLineName()));
            output.append("\n");
            for(ActivityListable activity: assemblyLine.getMorningPeriod().getActivities()){
                formatOneLine(output,elapsedTime, activity.getDescription());
                elapsedTime += activity.getDurationInMinutes();
            }

            formatOneLine(output,elapsedTime, assemblyLine.getLunchPeriod().getDescription());
            elapsedTime += assemblyLine.getLunchPeriod().getDurationInMinutes();

            for(ActivityListable activity: assemblyLine.getAfternoonPeriod().getActivities()){
                formatOneLine(output,elapsedTime, activity.getDescription());
                elapsedTime += activity.getDurationInMinutes();
            }
            output.append("\n");
        }
        return output.toString();
    }
    public void formatOneLine(StringBuffer output, int elapsedTime, String description){
        String time = TimeConversion.getTimeFormated(elapsedTime);
        output.append(time).append(" ").append(description).append("\n");
    }
}
