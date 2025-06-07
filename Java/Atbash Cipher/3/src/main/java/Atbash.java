class Atbash {
    String encode(String input) {
        StringBuilder encoded = new StringBuilder();
        int characterCount = 0;
        
        for (char character: input.toCharArray()) {
            if (!Character.isLetterOrDigit(character)) {
                continue;
            }
            if (characterCount % 5 == 0 && characterCount != 0) {
                encoded.append(" ");
            }

            char processedChar = Character.isLetter(character) ? cipherChar(character) : character;
            encoded.append(processedChar);

            characterCount++;
        }
        
        return encoded.toString();
    }

    String decode(String input) {
        StringBuilder decoded = new StringBuilder();
        
        for (char character: input.toCharArray()) {
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