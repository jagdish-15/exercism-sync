class ReverseString {

    String reverse(String inputString) {
        String newString = "";

        for(int i = inputString.length() - 1; i >= 0; i--) {
            newString += String.valueOf(inputString.charAt(i));
        }

        return newString;
    }
}