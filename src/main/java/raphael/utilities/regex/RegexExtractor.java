package raphael.utilities.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtractor {
    public static String extractFirstPatternFromText(String regex, String text, int group, String returnIfPatternNotFound){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return(matcher.group(group));
        }else{
            return returnIfPatternNotFound;
        }
    }
}
