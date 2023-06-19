package raphael.utilities.logs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssemblyLineLog {
    private static final Logger logger = LogManager.getLogger();
    public static void error(String message){
        logger.error(message);
    }
    public static void warn(String message){logger.warn(message);}
}
