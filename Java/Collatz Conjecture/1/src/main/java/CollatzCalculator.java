class CollatzCalculator {

    // Method that returns steps required for Collatz falacy
    public static int computeStepCount(int start) {
        
        int stepCount = 0; // Variable that saves number of steps

        // While loop which computes till 1
        while(start != 1) {
            
            // Condition to avoid numbers below 1
            if(start < 1) {
                throw new IllegalArgumentException("Only positive integers are allowed");
            }

            // Performing operations depending on odd or even state
            if(start % 2 == 0) {
                start /= 2;
            } else{
                start = 3 * start + 1;
            }

            stepCount++; // Incrementing number of steps
        }

        return stepCount;
    }
}