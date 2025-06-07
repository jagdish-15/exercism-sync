class Atbash {
    String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        int characterCount = 0;
        
        for (int  i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            
            if (Character.isLetterOrDigit(character)) {
                if (characterCount % 5 == 0 && characterCount != 0) {
                    encoded.append(" ");
                }

                if (Character.isLetter(character)) {
                    encoded.append(cipherChar(character));
                } else {
                    encoded.append(character);
                }
                characterCount++;
            }
        }
        return encoded.toString();
    }

    String decode(String input) {
        StringBuilder decoded = new StringBuilder();
        
        for (int  i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            
            if (Character.isLetter(character)) {
                decoded.append(cipherChar(character));    
            }
            if (Character.isDigit(character)) {
                decoded.append(character);
            }
        }
        return decoded.toString();
    }

    private char cipherChar(char character) {
        character = Character.toLowerCase(character);
        return (char) ( 2 * 'a' + 25 - character);
    }
}