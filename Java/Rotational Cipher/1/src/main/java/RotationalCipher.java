class RotationalCipher {
    public int shiftKey;
    
    RotationalCipher(int shiftKey) {
            this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        char[] letters = data.toCharArray();
        StringBuilder rotated = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            int letterInt = (int) letters[i];

            if (letterInt > 64 && letterInt < 91) {
                letterInt += shiftKey;
                if (letterInt > 90) {
                    letterInt -= 26;
                }
            } else if (letterInt > 96 && letterInt < 123) {
                letterInt += shiftKey;
                if (letterInt > 122) {
                    letterInt -= 26;
                }
            }
            
            rotated.append((char) letterInt);
        }

        return rotated.toString();
    }

}