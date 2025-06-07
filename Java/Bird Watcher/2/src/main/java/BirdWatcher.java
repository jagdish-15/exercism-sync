
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }
 
    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] ++;
    }

    public boolean hasDayWithoutBirds() {
        for(int birds: birdsPerDay) {
            if(birds == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;

        // To avoid OutOfBoundException
        if(numberOfDays > birdsPerDay.length) {
            numberOfDays = birdsPerDay.length; 
        }

        for(int i = 0; i < numberOfDays; i++) {
            sum += birdsPerDay[i];
        }
        
        return sum;
    }

    public int getBusyDays() {
        int numberOfBusyDays = 0;

        for(int birds: birdsPerDay) {
            if(birds >= 5) numberOfBusyDays += 1;
        }
        
        return numberOfBusyDays;
    }
}