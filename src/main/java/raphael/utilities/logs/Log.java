package raphael.utilities.logs;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;

public class Log {
    private static final Logger logger = LogManager.getLogger();
    private static final String ERROR_LOG_FILE_LOCATION = Paths.get( System.getProperty("user.dir") +"/logs").toString();
    public static void error(String message){
        System.setProperty("log",ERROR_LOG_FILE_LOCATION);
        logger.error(message);
    }
}
