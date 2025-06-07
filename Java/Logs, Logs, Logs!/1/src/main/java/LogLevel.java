public enum LogLevel {
    TRACE(1, "TRC"),
    DEBUG(2, "DBG"),
    INFO(4, "INF"),
    WARNING(5, "WRN"),
    ERROR(6, "ERR"),
    FATAL(42, "FTL"),
    UNKNOWN(0, "UNK"); // You can use a standard abbreviation for unknown

    private final int encodedLogLevel;
    private final String abbreviation;

    LogLevel(int encodedLogLevel, String abbreviation) {
        this.encodedLogLevel = encodedLogLevel;
        this.abbreviation = abbreviation;
    }

    public int getEncodedLogLevel() {
        return this.encodedLogLevel;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public static LogLevel fromAbbreviation(String abbreviation) {
        for (LogLevel level : values()) {
            if (level.getAbbreviation().equals(abbreviation)) {
                return level;
            }
        }
        return UNKNOWN; // Return UNKNOWN if the abbreviation is not found
    }
}

