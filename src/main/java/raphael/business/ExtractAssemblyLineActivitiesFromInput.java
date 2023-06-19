package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.utilities.logs.AssemblyLineLog;
import raphael.utilities.regex.RegexExtractor;

import java.util.ArrayList;
import java.util.Objects;

public class ExtractAssemblyLineActivitiesFromInput {
    public static final String REGEX_FIND_ONLY_MINUTES = "(\\d+)min";
    public static final String PATTERN_FIND_MAINTENANCE = "- MAINTENANCE";


   public static ArrayList<AssemblyLineActivity> extract(ArrayList<String> linesFromInputFile ){
        ArrayList<AssemblyLineActivity> extractedActivitiesList = new ArrayList<AssemblyLineActivity>();
        AssemblyLineActivity oneAssemblyLineActivity;
        for(String line : linesFromInputFile){
            if("".equals(line.trim())){
                AssemblyLineLog.warn("Foi ignorado uma linha em branco");
                continue;
            }
            oneAssemblyLineActivity = extractActivityFromOneLine(line);
            extractedActivitiesList.add(oneAssemblyLineActivity);
        }
        return extractedActivitiesList;
    }
    public static AssemblyLineActivity extractActivityFromOneLine(String line){
        int activityDurationInMinutes = 0;
        String activityDescription="";

        Objects.requireNonNull(line);

        int indexOfMaintenance = line.toUpperCase().indexOf(PATTERN_FIND_MAINTENANCE);
        if( indexOfMaintenance != -1){
            activityDurationInMinutes= AssemblyLineActivity.ACTIVITY_MAINTENANCE_DURATION_IN_MINUTES;
            activityDescription=line.substring(0,indexOfMaintenance);
        }else {
            activityDurationInMinutes  = Integer.parseInt(RegexExtractor.extractFirstPatternFromText(REGEX_FIND_ONLY_MINUTES, line, 1, "0"));
            activityDescription = RegexExtractor.extractTextReplacingPattern(REGEX_FIND_ONLY_MINUTES,line ,0,"");
        }
        return new AssemblyLineActivity(activityDurationInMinutes,activityDescription);
    }
}

