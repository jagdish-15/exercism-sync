class IsogramChecker {

    boolean isIsogram(String phrase) {

        phrase = phrase.toLowerCase();
        phrase = phrase.replaceAll("-", "");
        phrase = phrase.replaceAll(" ", "");

        for (int i = 0; i < phrase.length(); i++) {
            for (int j = 0; j < phrase.length(); j++) {
                if (phrase.charAt(i) == phrase.charAt(j) && i != j) {
                    return false;
                }
            }
        }

        return true;
    }

}
