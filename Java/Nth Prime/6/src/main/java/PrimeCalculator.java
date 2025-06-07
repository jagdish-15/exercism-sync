public class PrimeCalculator {

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        PrimeGenerator generator = new PrimeGenerator();
        int indexOfPrime = 1;
        while (true) {
            int currentPrime = generator.nextPrime();
            if (indexOfPrime == nth) {
                return currentPrime;
            }
            indexOfPrime++;
        }
    }
}

class PrimeGenerator {
    private int current = 1;
    
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

    public int nextPrime() {
        while (true) {
            current++;
            if (isPrime(current)) {
                return current;
            }
        }
    }
}