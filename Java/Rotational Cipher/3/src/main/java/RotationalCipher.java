class RotationalCipher {
    public int shiftKey;
    
    RotationalCipher(int shiftKey) {
            this.shiftKey = shiftKey;
    }

    private char rotate(char character) {
        if (Character.isUpperCase(character)) {
            return (char) ((character - 'A' + shiftKey) % 26 + 'A');
        } else if (Character.isLowerCase(character)) {
            return (char) ((character - 'a' + shiftKey) % 26 + 'a');
        } else {
            return character;
        }
    }

    String rotate(String data) {
        StringBuilder rotated = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            rotated.append(rotate(data.charAt(i)));
        }
        return rotated.toString();
    }

}