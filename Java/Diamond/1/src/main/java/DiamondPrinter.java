import java.util.List;
import java.util.ArrayList;

class DiamondPrinter {

    List<String> printToList(char a) {
        int rows = a - 'A' + 1;
        int totalColumns = rows * 2 - 1;
        char currentChar = 'A';
        List<String> list = new ArrayList<>();

        for (int row = 1; row <= rows; row++) {
            StringBuilder currentString = new StringBuilder();
            int centerRegion = row * 2 - 1;
            int initialSpaces = (totalColumns - centerRegion) / 2;
            for (int i = 0; i < initialSpaces; i++) {
                currentString.append(" ");
            }
            for (int i = 0; i < centerRegion; i++) {
                currentString.append((i == 0 || i == centerRegion - 1) ? currentChar : " ");
            }
            for (int i = 0; i < initialSpaces; i++) {
                currentString.append(" ");
            }
            currentChar++;
            list.add(currentString.toString());
        }

        currentChar -= 2;
        for (int row = rows - 1; row > 0; row--) {
            StringBuilder currentString = new StringBuilder();
            int centerRegion = row * 2 - 1;
            int initialSpaces = (totalColumns - centerRegion) / 2;
            for (int i = 0; i < initialSpaces; i++) {
                currentString.append(" ");
            }
            for (int i = 0; i < centerRegion; i++) {
                currentString.append((i == 0 || i == centerRegion - 1) ? currentChar : " ");
            }
            for (int i = 0; i < initialSpaces; i++) {
                currentString.append(" ");
            }
            currentChar--;
            list.add(currentString.toString());
        }

        return list;
    }
}
