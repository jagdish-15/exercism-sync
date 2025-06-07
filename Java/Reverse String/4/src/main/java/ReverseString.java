class ReverseString {

    String reverse(String inputString) {
        
        StringBuilder newString = new StringBuilder(inputString.length());
        
        for(int i = inputString.length() - 1; i >= 0; i--) {
            newString.append(inputString.charAt(i));
        }

        // This is second method using in-built method in StringBuilder class
        // StringBuilder newString = new StringBuilder(inputString);
        // newString.reverse();

        return newString.toString();
    }
}