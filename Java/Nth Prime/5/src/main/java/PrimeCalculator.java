class PrimeCalculator {
    private boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        if (number < 2) {
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
            
        int nthCount = 1;
        int primeNumber = 2;
        while (nthCount < nth) {
            primeNumber += primeNumber == 2 ? 1 : 2;
            
            if (isPrime(primeNumber)) {
                nthCount++;
            }
        }
        return primeNumber;
    }
}