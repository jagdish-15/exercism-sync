import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Yacht {
    private final YachtCategory yachtCategory;
    private final int[] dice;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case YachtCategory.YACHT:
                return yachtScore();
            case YachtCategory.ONES:
                return numberScore(1);
            case YachtCategory.TWOS:
                return numberScore(2);
            case YachtCategory.THREES:
                return numberScore(3);
            case YachtCategory.FOURS:
                return numberScore(4);
            case YachtCategory.FIVES:
                return numberScore(5);
            case YachtCategory.SIXES:
                return numberScore(6);
            case YachtCategory.FULL_HOUSE:
                return fullHouseScore();
            case YachtCategory.FOUR_OF_A_KIND:
                return fourOfAKindScore();
            case YachtCategory.LITTLE_STRAIGHT:
                return straightScore(1);
            case YachtCategory.BIG_STRAIGHT:
                return straightScore(2);
            case YachtCategory.CHOICE:
                return choiceScore();
            default:
                return 0;
        }
    }

    int yachtScore() {
        for (int number: dice) {
            if (number != dice[0])
                return 0;
        }
        return 50;
    }

    int numberScore(int diceNumber) {
        int score = 0;
        for (int number: dice) {
            score += number == diceNumber ? number : 0;
        }
        return score;
    }

    int fullHouseScore() {
        int score = 0;
        Map<Integer, Integer> diceCountMap = new HashMap<>();
        for (int number: dice) {
            diceCountMap.put(number, diceCountMap.getOrDefault(number, 0) + 1);
            score += number;
        }
        if (!diceCountMap.containsValue(2) || !diceCountMap.containsValue(3))
            return 0;
        
        return score;
    }

    int fourOfAKindScore() {
        int[] freq = new int[7];
        for (int number: dice) {
            freq[number]++;

            if (freq[number] == 4)
                return number * 4;
        }
        return 0;
    }

    int straightScore(int num) {
        int[] straight = {num, num + 1, num + 2, num + 3, num + 4};
        Arrays.sort(dice);
        return Arrays.equals(dice, straight) ? 30 : 0;
    }

    ArrayList<Integer> convertToList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int number: array) {
            list.add(number);
        }
        return list;
    }
    
    int choiceScore() {
        int sum = 0;
        for (int number: dice) {
            sum += number;
        }
        return sum;
    }
}