public class TelemetryLoggerAdapter implements ISimpleLogger {
    private EnterpriseTelemetryLogger logger;
    private String appName;

    public TelemetryLoggerAdapter(EnterpriseTelemetryLogger logger, String appName) {
        this.logger = logger;
        this.appName = appName;
    }

    public void info(String message) {
        logger.writeLog(1, appName, message);
    }

    public void warn(String message) {
        logger.writeLog(2, appName, message);
    }

    public void error(String message) {
        logger.writeLog(3, appName, message);
    }
}