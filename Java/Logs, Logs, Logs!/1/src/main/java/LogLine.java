public class LogLine {
    private String logLine;
    
    public LogLine(String logLine) {
        this.logLine = logLine;
    }
    
    public LogLevel getLogLevel() {
        String level = this.logLine.substring(1, 4);
        return LogLevel.fromAbbreviation(level);
    }

    public String getOutputForShortLog() {
        int encodedLogLevel = getLogLevel().getEncodedLogLevel();
        String message = this.logLine.substring(7);
        return encodedLogLevel + ":" + message;
    }
}
