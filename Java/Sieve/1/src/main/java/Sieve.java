import java.util.List;
import java.util.ArrayList;

class Sieve {
    private int maxPrime;
    
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] isMarked = new boolean[maxPrime + 1];
        
        for (int i = 2; i <= maxPrime; i++) {
            if (isMarked[i] == false) {
                primes.add(i);
                for (int j = 1; j <= maxPrime / i; j++) {
                    isMarked[j * i] = true;
                }
            }
        }
        
        return primes;
    }
}
