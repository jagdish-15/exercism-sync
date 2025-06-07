class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        stringToVerify = stringToVerify.replaceAll("-", "");

        if(stringToVerify.length() != 10) {
            return false;
        }

        int[] allInts = new int[10];

        if(stringToVerify.charAt(9) == 'X') {
            allInts[9] = 10;
        } else {
            allInts[9] = stringToVerify.charAt(9) - '0';
        }
        
        for(int i = 0; i < 9; i++) {
            allInts[i] = stringToVerify.charAt(i) - '0';
        }

        int isbnValue = allInts[0] * 10 + allInts[1] * 9 + allInts[2] * 8 + allInts[3] * 7 + allInts[4] * 6 +
            allInts[5] * 5 + allInts[6] * 4 + allInts[7] * 3 + allInts[8] * 2 + allInts[9];

        return isbnValue % 11 == 0;
    }

}
