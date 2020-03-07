package CrossCutting;


import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;



public class LogContext {

    private Logger logger;

    public LogContext() {
        logger = Logger.getLogger(String.valueOf(LogContext.class));

        BasicConfigurator.configure();


        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile("applog.txt");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();
        logger.addAppender(fileAppender);
    }



    public Logger getLogger() {
        return logger;
    }
}
