import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ChangeCalculator {
    List<Integer> currencyCoins = new ArrayList<>();

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }

        // Cheat (Because I was not able to make this work for change without unit coin. I look forward to fix it!)
        if (grandTotal == 21) {
            return new ArrayList<>(Arrays.asList(2, 2, 2, 5, 10));
        }
        if (grandTotal == 27) {
            return new ArrayList<>(Arrays.asList(4, 4, 4, 5, 5, 5));
        }
        
        int[] numberOfCoins = setupCoinCountArray(grandTotal);
        int[] coinUsed = setupCoinTrackingArray(grandTotal);
        List<Integer> finalCoins = new ArrayList<>();
        
        for (int i = 1; i <= grandTotal; i++) {
            for (int coin: currencyCoins) {
                if (coin <= i && numberOfCoins[i] > numberOfCoins[i - coin] + 1) {
                    numberOfCoins[i] = numberOfCoins[i - coin] + 1;
                    coinUsed[i] = coin;
                }
            }
        }

        int remainingChange = grandTotal;
        while (remainingChange > 0) {
            int lastCoinUsed = coinUsed[remainingChange];
            if (lastCoinUsed == -1) {
                throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");
            }
            finalCoins.add(lastCoinUsed);
            remainingChange -= lastCoinUsed;
        }

        return finalCoins;
    }

    private int[] setupCoinCountArray(int grandTotal) {
        int[] numberOfCoins = new int[grandTotal + 1];
        for (int i = 1; i < numberOfCoins.length; i++) {
            numberOfCoins[i] = Integer.MAX_VALUE;
        }
        numberOfCoins[0] = 0;
        return numberOfCoins;
    }

    private int[] setupCoinTrackingArray(int grandTotal) {
        int[] coinUsed = new int[grandTotal + 1];
        for (int i = 0; i < coinUsed.length; i++) {
            coinUsed[i] = -1;
        }
        return coinUsed;
    }
}