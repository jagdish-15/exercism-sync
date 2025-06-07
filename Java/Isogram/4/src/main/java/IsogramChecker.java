import java.util.Set;
import java.util.HashSet;


class IsogramChecker {

    boolean isIsogram(String phrase) {
        phrase = phrase.toLowerCase().replaceAll("-", "").replaceAll(" ", "");
        char[] lettersOfPhrase = phrase.toCharArray();

        Set<Character> letters = new HashSet<>();
        
        for (char letter: lettersOfPhrase) {
            if(!letters.add(letter)) {
                return false;
            }
        }

        return true;
    }

}
