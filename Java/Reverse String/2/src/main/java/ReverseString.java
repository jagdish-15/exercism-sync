class ReverseString {

    String reverse(String inputString) {
        String newString = "";

        for(int i = inputString.length() - 1; i >= 0; i--) {
            newString += inputString.charAt(i);
        }

        return newString;
    }
}