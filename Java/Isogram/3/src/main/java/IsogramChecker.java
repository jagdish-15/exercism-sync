import java.util.Set;
import java.util.HashSet;


class IsogramChecker {

    boolean isIsogram(String phrase) {
        phrase = phrase.toLowerCase().replaceAll("-", "").replaceAll(" ", "");

        Set<Character> letters = new HashSet<>();
        
        for (int i = 0; i < phrase.length(); i++) {
            letters.add(phrase.charAt(i));
        }

        if (phrase.length() == letters.size()) {
            return true;
        } else {
            return false;
        }
    }

}
