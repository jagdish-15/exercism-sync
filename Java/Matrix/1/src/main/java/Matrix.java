class Matrix {

    private int[][] matrix;
    private int Rows;
    private int Columns;

    Matrix(String matrixAsString) {
        String[] matrixAsArrayOfString = matrixAsString.split("[\\n ]+");
        Rows = matrixAsString.split("\\n").length;
        Columns = matrixAsArrayOfString.length / Rows;

        matrix = new int[Rows][Columns];
        
        int index = 0;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                matrix[i][j] = 
                    Integer.parseInt(matrixAsArrayOfString[index++]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] requiredColumn = new int[Rows];
        for (int i = 0; i < Rows; i++) {
            requiredColumn[i] = matrix[i][columnNumber - 1];
        }
        return requiredColumn;
    }
}