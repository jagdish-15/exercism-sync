import java.util.List;
import java.util.ArrayList;

class Allergies {
    private final int score;
    
    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        List<Allergen> allergenList = getList();
        return allergenList.contains(allergen);
    }

    List<Allergen> getList() {
        List<Allergen> allergenList = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            if (isKthBitSet(score, i)) {
                allergenList.add(getAllergenByScore(1 << i));
            }
        }
        return allergenList;
    }

    private Allergen getAllergenByScore(int score) {
        for (Allergen allergen: Allergen.values()) {
            if (score == allergen.getScore()) {
                return allergen;
            }
        }
        return null;
    }

    private boolean isKthBitSet(int num, int k) {
        return (num & (1 << k)) != 0;
    }
}