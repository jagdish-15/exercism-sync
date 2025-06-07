import java.util.List;
import java.util.ArrayList;

class Allergies {
    private final int score;
    
    Allergies(int score) {
        this.score = score;
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) != 0;
    }

    List<Allergen> getList() {
        List<Allergen> allergenList = new ArrayList<>();
        for (Allergen allergen: Allergen.values()) {
            if ((score & allergen.getScore()) != 0)
                allergenList.add(allergen);
        }
        return allergenList;
    }
}