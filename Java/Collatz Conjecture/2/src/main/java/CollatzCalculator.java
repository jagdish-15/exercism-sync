class CollatzCalculator {

    public static int computeStepCount(int start) {
        
        int stepCount = 0; 

        if(start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        while(start != 1) {
            if(start % 2 == 0) {
                start /= 2;
            } else{
                start = 3 * start + 1;
            }
            stepCount++;
        }

        return stepCount;
    }
}