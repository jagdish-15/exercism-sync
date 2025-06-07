class PrimeCalculator {

    private boolean isPrime(int number) {
        if (number == 2) {
            return true;
        } else if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }
            
        int nthCount = 0;
        int  i = 2;
        
        while (true) {
            if (isPrime(i)) {
                nthCount++;
            }
            if (nthCount == nth) {
                return i;
            }
            i++;
        }
    }
}