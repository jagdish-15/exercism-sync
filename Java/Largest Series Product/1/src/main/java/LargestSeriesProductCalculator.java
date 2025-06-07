class LargestSeriesProductCalculator {
    private String inputNumber;
    
    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("\\d*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        int length = inputNumber.length();
        
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if (numberOfDigits > length) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        
        int numberOfSeries = inputNumber.length() - numberOfDigits + 1;
        int substringStart = 0;
        long largestSeriesProduct = 1;

        for (int i = 0; i < numberOfSeries; i++) {
            long seriesProduct = 1;
            String seriesString = inputNumber.substring(substringStart, substringStart + numberOfDigits);
            
            for (int j = 0; j < numberOfDigits; j++) {
                seriesProduct *= Integer.parseInt(seriesString.substring(j, j + 1));
            }
            
            if (seriesProduct > largestSeriesProduct) {
                largestSeriesProduct = seriesProduct;
            }

            substringStart++;
        }
        
        if (largestSeriesProduct == 1) {
            largestSeriesProduct = 0;
        }
        
        return largestSeriesProduct;
    }
}
