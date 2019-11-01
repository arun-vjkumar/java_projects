package threadInfo;

import java.util.logging.Logger;

public class ThreadDetails {
    private static Logger logger = Logger.getLogger(ThreadDetails.class.getName());

    public static void printThreadDetails(Thread thread) {
        logger.info("Thread Details Is As Follows");
        logger.info(String.format("Thread Id: %d", thread.getId()));
        logger.info(String.format("Thread Name: %s", thread.getName()));
        logger.info(String.format("Thread Priority Level: %d", thread.getPriority()));
        logger.info(String.format("Thread State: %s", thread.getState()));
        logger.info(String.format("Thread Group: %s",thread.getThreadGroup()));
    }
}
