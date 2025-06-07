import java.util.Set;
import java.util.HashSet;

public class PangramChecker {

    public boolean isPangram(String input) {
        Set<Character> letterSet = new HashSet<>();

        for (char character: input.toLowerCase().toCharArray()) {
            if (Character.isLetter(character))
                letterSet.add(character);
        }

        return letterSet.size() == 26;
    }
    
}
