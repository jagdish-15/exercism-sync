class ReverseString {

    String reverse(String inputString) {
        
        StringBuilder newString = new StringBuilder(inputString.length());

        // newString.append(inputString);
        // newString.reverse();

        for(int i = inputString.length() - 1; i >= 0; i--) {
            newString.append(inputString.charAt(i));
        }

        return newString.toString();
    }
}