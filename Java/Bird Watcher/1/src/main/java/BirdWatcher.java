
class BirdWatcher {
    private final int[] birdsPerDay;

    // Constructor method
    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    
    // Method which gives last week detail
    public int[] getLastWeek() {
        int[] lastWeekBirdsPerDay = {0, 2, 5, 3, 7, 8, 4};
        return lastWeekBirdsPerDay;
    }

    
    // Method that returns today's bird visit count
    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    
    // Method to increment bird visit for the current day
    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1] += 1;
    }

    
    // Method that checks whether the current week has days without bird visits
    public boolean hasDayWithoutBirds() {
        // For each loop for checking of any day of a week has day without bird visit
        for(int birds: birdsPerDay) {
            if(birds == 0) {
                return true;
            }
        }
        return false;
    }

    
    // Method that calculates number of birds in first number of days
    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0; // Declaring variable to be returned

        // Condition to avoid OutOfBoundException
        if(numberOfDays > birdsPerDay.length) numberOfDays = birdsPerDay.length; 

        // For loop for adding the numbers
        for(int i = 0; i < numberOfDays; i++) {
            sum += birdsPerDay[i];
        }
        
        return sum;
    }

    
    //  Method that gives number of busy days
    public int getBusyDays() {
        int numberOfBusyDays = 0; // Declaring variable to be returned

        // For each loop for finding busy days
        for(int birds: birdsPerDay) {
            if(birds >= 5) numberOfBusyDays += 1;
        }
        
        return numberOfBusyDays;
    }
}
