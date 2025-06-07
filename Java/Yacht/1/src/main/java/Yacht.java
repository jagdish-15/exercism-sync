import java.util.ArrayList;

class Yacht {
    private YachtCategory yachtCategory;
    int[] dice;

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
        int numberCount = 0;
        for (int number: dice) {
            if (number == diceNumber)
                numberCount++;
        }
        return numberCount * diceNumber;
    }

    int fullHouseScore() {
        int firstNumber = dice[0];
        int firstCount = 0;
        int secondNumber = 0;
        
        for (int number: dice) {
            if (number == firstNumber) {
                firstCount++;
            } else if (secondNumber == 0 || number == secondNumber) {
                secondNumber = number;
            } else {
                return 0;
            }
        }
        
        if (firstCount == 3 || firstCount == 2)
            return firstNumber * firstCount + secondNumber * (5 - firstCount);
        return 0;
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

    int straightScore(int startNumber) {
        ArrayList<Integer> diceList = convertToList(dice);
        for (int i = startNumber; i < startNumber + 5; i++) {
            if (!diceList.contains(i))
                return 0;
        }
        return 30;
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