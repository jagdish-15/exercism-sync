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
        
        int numberOfSeries = length - numberOfDigits + 1;
        long largestSeriesProduct = 0;

        for (int i = 0; i < numberOfSeries; i++) {
            long localSeriesProduct = 1;
            for (int j = 0; j < numberOfDigits; j++) {
                localSeriesProduct *= inputNumber.charAt(i + j) - '0';
            }
            largestSeriesProduct = Math.max(largestSeriesProduct, localSeriesProduct);
        }
        
        return largestSeriesProduct;
    }
}
