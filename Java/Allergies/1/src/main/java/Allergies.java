import java.util.List;
import java.util.ArrayList;

class Allergies {
    private final int score;
    private static final int MAX_SCORE = 128;
    
    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        List<Allergen> allergenList = getList();
        return allergenList.contains(allergen);
    }

    List<Allergen> getList() {
        List<Allergen> allergenList = new ArrayList<>();
        int tempScore = score;
        while (tempScore > 0) {
            int currentAllergyScore = getLargestAllergyByScore(tempScore);
            if (currentAllergyScore <= MAX_SCORE) {
                allergenList.add(0, getAllergenByScore(currentAllergyScore));
            }
            tempScore -= currentAllergyScore;
        }
        return allergenList;
    }

    private static int getLargestAllergyByScore(int score) {
        for (int i = 2; true; i *= 2) {
            if (score < i) {
                return i / 2;
            }
        }
    }

    private Allergen getAllergenByScore(int score) {
        for (Allergen allergen: Allergen.values()) {
            if (score == allergen.getScore()) {
                return allergen;
            }
        }
        return null;
    }
}