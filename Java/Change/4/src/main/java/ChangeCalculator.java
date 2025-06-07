import java.util.List;
import java.util.ArrayList;

class ChangeCalculator {
    List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) 
            throw new IllegalArgumentException("Negative totals are not allowed.");

        List<List<Integer>> coinsUsed = new ArrayList<>(grandTotal + 1);
        coinsUsed.add(new ArrayList<Integer>());

        for (int i = 1; i <= grandTotal; i++) {
            coinsUsed.add(new ArrayList<Integer>());
            for (int coin: currencyCoins) {
                if (coin <= i && !coinsUsed.get(i - coin).isEmpty() || i - coin == 0) {
                    List<Integer> combination = new ArrayList<>(coinsUsed.get(i - coin));
                    combination.add(0, coin);
                    if (coinsUsed.get(i).isEmpty() || combination.size() < coinsUsed.get(i).size())
                        coinsUsed.set(i, combination);
                }
            }
        }

        if (coinsUsed.get(grandTotal).isEmpty() && grandTotal != 0)
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");

        return coinsUsed.get(grandTotal);
    }
}