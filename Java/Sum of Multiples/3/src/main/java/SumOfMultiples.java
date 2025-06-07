import java.util.HashSet;

class SumOfMultiples {

    private final int number;
    private final int[] set;
    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        HashSet<Integer> allMultiples = new HashSet<>();
        for (int baseValue: set) {
            if (baseValue <= 0) {
                continue;
            }
            for (int multiple = baseValue; multiple < number; multiple += baseValue) {
                allMultiples.add(multiple);
            }
        }

        int sum = 0;
        for (int multiple: allMultiples) {
            sum += multiple;
        }
        return sum;    
    }
}