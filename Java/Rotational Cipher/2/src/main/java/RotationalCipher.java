class RotationalCipher {
    public int shiftKey;
    
    RotationalCipher(int shiftKey) {
            this.shiftKey = shiftKey;
    }

    private char rotate(char character) {
        if (character > 64 && character < 91) {
            character += shiftKey;
            if (character > 90) {
                character -= 26;
            }
        }
        if (character > 96 && character < 123) {
            character += shiftKey;
            if (character > 122) {
                character -= 26;
            }
        }

        return character;
    }

    String rotate(String data) {
        StringBuilder rotated = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            rotated.append(rotate(data.charAt(i)));
        }
        return rotated.toString();
    }

}