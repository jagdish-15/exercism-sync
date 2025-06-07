class Matrix {

    private int[][] matrix;

    Matrix(String matrixAsString) {
        String[] matrixAsArrayOfString = matrixAsString.split("[\\n ]+");
        int rows = matrixAsString.split("\\n").length;
        int columns = matrixAsArrayOfString.length / rows;

        matrix = new int[rows][columns];
        
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(matrixAsArrayOfString[index++]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] requiredColumn = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            requiredColumn[i] = matrix[i][columnNumber - 1];
        }
        return requiredColumn;
    }
}