class RotationalCipher {
    public int shiftKey;
    
    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    private char rotate(char character) {
        if (!Character.isLetter(character))
            return character;
        char pivot = Character.isUpperCase(character) ? 'A' : 'a';
        return (char) ((character - pivot + shiftKey) % 26 + pivot);
    }

    String rotate(String data) {
        StringBuilder rotated = new StringBuilder();
        for (int i = 0; i < data.length(); i++)
            rotated.append(rotate(data.charAt(i)));
        return rotated.toString();
    }

}