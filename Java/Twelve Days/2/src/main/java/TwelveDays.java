class TwelveDays {
    private static final int TOTAL_VERSES = 12;
    private String[] song = new String[TOTAL_VERSES];
    
    String verse(int verseNumber) {
        generateSongUptoVerse(verseNumber);
        return song[verseNumber - 1] + "\n";
    }

    String verses(int startVerse, int endVerse) {
        generateSongUptoVerse(endVerse);
        StringBuilder verses = new StringBuilder();
        for (int i = startVerse - 1; i < endVerse; i++) {
            verses.append(song[i]).append(i == endVerse - 1? "\n": "\n\n");
        }
        return verses.toString();
    }
    
    String sing() {
        generateSongUptoVerse(TOTAL_VERSES);
        StringBuilder verses = new StringBuilder();
        for (int i = 0; i < TOTAL_VERSES; i++) {
            verses.append(song[i]).append(i == TOTAL_VERSES - 1? "\n": "\n\n");
        }
        return verses.toString();
    }

    private void generateSongUptoVerse(int verse) {
        for (int i = 0; i < verse; i++) {
            StringBuilder line = new StringBuilder();
            line.append("On the ").append(getDay(i + 1)).append(" day of Christmas my true love gave to me: ");
            
            for (int j = i + 1; j > 0; j--) {
                if (j == 1 && i != 0) {
                    line.append("and ");
                }
                line.append(getPresent(j)).append(j != 1? ", ": "");
            }

            song[i] = line.toString();
        }
    }

    private String getDay(int day) {
        switch (day) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth"; // The spelling is intentionally wrong since the test requires
            default:
                throw new IllegalArgumentException("The argument allowed are from 1 to 12");
        }
    }

    private String getPresent(int day) {
        switch (day) {
            case 1:
                return "a Partridge in a Pear Tree.";
            case 2:
                return "two Turtle Doves";
            case 3:
                return "three French Hens";
            case 4:
                return "four Calling Birds";
            case 5:
                return "five Gold Rings";
            case 6:
                return "six Geese-a-Laying";
            case 7:
                return "seven Swans-a-Swimming";
            case 8:
                return "eight Maids-a-Milking";
            case 9:
                return "nine Ladies Dancing";
            case 10:
                return "ten Lords-a-Leaping";
            case 11:
                return "eleven Pipers Piping";
            case 12:
                return "twelve Drummers Drumming";
            default:
                throw new IllegalArgumentException("The argument values allowed are from 1 to 12");
        }
    }
}