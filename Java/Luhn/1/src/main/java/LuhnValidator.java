import java.util.ArrayList;

class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.toLowerCase().replaceAll(" ", "");
        
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < candidate.length(); i++) {
            digits.add(candidate.charAt(i) - '0');
        }

        if (digits.size() < 2) {
            return false; // Minumum requirement for Luhn number is 2 digits
        }

        int sum = 0;
        boolean doubleDigit = false;
        for (int i = digits.size() - 1; i >= 0; i--) {
            int digit = digits.get(i);
            
            if (digit > 9) {
                return false; // If non-numbers are found it will yeild digit larger than 9
            } else if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            
            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}
