class Bob {
    String hey(String input) {
        String inputTrimmed = input.trim();
        
        if (isEmpty(inputTrimmed)) {
           return "Fine. Be that way!"; 
        } else if (isYelling(inputTrimmed) && isAsking(inputTrimmed)) {
            return "Calm down, I know what I'm doing!";
        } else if (isYelling(inputTrimmed)) {
            return "Whoa, chill out!";
        } else if (isAsking(inputTrimmed)) {
            return "Sure.";
        } else {
            return "Whatever.";
        }
    }

    private boolean isYelling(String input) {
        boolean isYelling = false;
        for (char character: input.toCharArray()) {
            if (Character.isLetter(character)) {
                if (Character.isLowerCase(character)) {
                    return false;
                }
                isYelling = true;
            }
        }
        return isYelling;
    }

    private boolean isAsking(String input) {
        return input.charAt(input.length() - 1) == '?';
    }

    private boolean isEmpty(String input) {
        return input.length() == 0;
    }
}