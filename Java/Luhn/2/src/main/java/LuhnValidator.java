class LuhnValidator {

    boolean isValid(String candidate) {

        String sanitizedCandidate = candidate.replaceAll(" ", "");
        
        if (!sanitizedCandidate.matches("\\d{2,}")) {
            return false;
        }

        int sum = 0;
        boolean doubleDigit = false;
        
        for (int i = sanitizedCandidate.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(sanitizedCandidate.charAt(i));
            int doubledDigit = digit * 2;  
            
            sum += doubleDigit ? (doubledDigit > 9 ? doubledDigit - 9 : doubledDigit) : digit; 
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }
}