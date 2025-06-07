import java.util.HashSet;

class SumOfMultiples {

    int number;
    int[] set;
    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        HashSet<Integer> allMultiples = new HashSet<Integer>();
        for (int i = 0; i < set.length; i++) {
            int baseValue = set[i];
            if (baseValue == 0)
                continue;
            for (int j = 1; baseValue * j < number; j++)
                allMultiples.add(baseValue * j);
        }

        int sum = 0;
        for (int multiple: allMultiples)
            sum += multiple;
        return sum;    
    }
}