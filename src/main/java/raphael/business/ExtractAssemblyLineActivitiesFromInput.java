package raphael.business;

import raphael.entities.activities.AssemblyLineActivity;
import raphael.utilities.regex.RegexExtractor;

import java.util.ArrayList;

public class ExtractAssemblyLineActivitiesFromInput {
    public static final String REGEX_FIND_ONLY_MINUTES = "(\\d+)min";
    public static final String PATTERN_FIND_MAINTENANCE = "- MAINTENANCE";


   public static ArrayList<AssemblyLineActivity> extract(ArrayList<String> linesFromInputFile ){
        ArrayList<AssemblyLineActivity> extractedActivitiesList = new ArrayList<AssemblyLineActivity>();
        AssemblyLineActivity oneAssemblyLineActivity;
        for(String line : linesFromInputFile){
            oneAssemblyLineActivity = extractActivityFromOneLine(line);
            extractedActivitiesList.add(oneAssemblyLineActivity);
        }
        return extractedActivitiesList;
    }
    private static AssemblyLineActivity extractActivityFromOneLine(String line){
        int activityDurationInMinutes = 0;
        String activityDescription="";

        int indexOfMaintenance = line.toUpperCase().indexOf(PATTERN_FIND_MAINTENANCE);
        if( indexOfMaintenance != -1){
            activityDurationInMinutes= AssemblyLineActivity.ACTIVITY_MAINTENANCE_DURATION_IN_MINUTES;
            activityDescription=line.substring(0,indexOfMaintenance);
        }else {
            activityDurationInMinutes  = Integer.parseInt(RegexExtractor.extractFirstPatternFromText(REGEX_FIND_ONLY_MINUTES, line, 1, "0"));
            activityDescription = RegexExtractor.extractTextReplacingPattern(REGEX_FIND_ONLY_MINUTES,line ,1,"");
        }
        return new AssemblyLineActivity(activityDurationInMinutes,activityDescription);
    }
}

