import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Sieve {
    private int maxPrime;
    
    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<Integer>();
        Set<Integer> markedNumbers = new HashSet<>();
        
        for (int i = 2; i <= maxPrime; i++) {
            if (!markedNumbers.contains(i)) {
                primes.add(i);
                for (int j = i; j <= maxPrime / i; j++) {
                    markedNumbers.add(i * j);
                }
            }
        }
        
        return primes;
    }
}
