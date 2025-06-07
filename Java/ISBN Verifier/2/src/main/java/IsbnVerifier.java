class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        stringToVerify = stringToVerify.replaceAll("-", "");

        if (stringToVerify.length() != 10) {
            return false;
        }

        int[] allDigits = new int[10];

        for (int i = 0; i < 10; i++) {
            if (stringToVerify.charAt(i) == 'X' && i != 9) {
                return false;
            } else if (stringToVerify.charAt(i) == 'X') {
                allDigits[i] = 10;
            } else {
                allDigits[i] = stringToVerify.charAt(i) - '0';
            }
        }

        int isbnValue = 0;

        for (int i = 0; i < 10; i++) {
            isbnValue += allDigits[i] * (10 - i);
        }

        return isbnValue % 11 == 0;
    }

}
