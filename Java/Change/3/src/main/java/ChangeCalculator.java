import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ChangeCalculator {
    List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }

        int[] numberOfCoins = new int[grandTotal + 1];
        int[] coinUsed = new int[grandTotal + 1];

        Arrays.fill(numberOfCoins, Integer.MAX_VALUE);
        numberOfCoins[0] = 0;

        for (int i = 1; i <= grandTotal; i++) {
            for (int coin : currencyCoins) {
                if (coin <= i && numberOfCoins[i - coin] != Integer.MAX_VALUE && numberOfCoins[i] > numberOfCoins[i - coin] + 1) {
                    numberOfCoins[i] = numberOfCoins[i - coin] + 1;
                    coinUsed[i] = coin;
                }
            }
        }

        if (numberOfCoins[grandTotal] == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
        }

        List<Integer> finalCoins = new ArrayList<>();
        int remainingChange = grandTotal;

        while (remainingChange > 0) {
            int lastCoinUsed = coinUsed[remainingChange];
            finalCoins.add(lastCoinUsed);
            remainingChange -= lastCoinUsed;
        }

        return finalCoins;
    }
}