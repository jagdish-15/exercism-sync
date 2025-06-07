public class CarsAssemble {

    private static final int BASE_PRODUCTION_RATE = 221;

    public double productionRatePerHour(int speed) {
        return BASE_PRODUCTION_RATE * speed * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }

    private double getSuccessRate(int speed) {
        if (speed == 10)
            return 0.77;
        if (speed  == 9)
            return 0.8;
        if (speed > 4)
            return 0.9;
        
        return 1;
    }
}
