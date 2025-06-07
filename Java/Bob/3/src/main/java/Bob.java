class Bob {
    String hey(String input) {
        var inputTrimmed = input.trim();
        
        if (isSilent(inputTrimmed))
           return "Fine. Be that way!";
        if (isYelling(inputTrimmed) && isAsking(inputTrimmed))
            return "Calm down, I know what I'm doing!";
        if (isYelling(inputTrimmed))
            return "Whoa, chill out!";
        if (isAsking(inputTrimmed))
            return "Sure.";
            
        return "Whatever.";
    }

    private boolean isYelling(String input) {
        return input.chars()
                    .filter(Character::isLetter)
                    .count() > 0 &&
                input.chars()
                    .filter(Character::isLetter)
                    .allMatch(Character::isUpperCase);
    }

    private boolean isAsking(String input) {
        return input.endsWith("?");
    }

    private boolean isSilent(String input) {
        return input.length() == 0;
    }
}