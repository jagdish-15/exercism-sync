import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Matrix {

    public List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        int rows = values.size();
        if (rows == 0)
            return saddlePoints;
        int columns = values.get(0).size();
        int[] tallestInRows = new int[rows];
        int[] shortestInColumns = new int[columns];

        for (int i = 0; i < rows; i++) {
            int tallest = Integer.MIN_VALUE;
            for (int j = 0; j < columns; j++)
                tallest = Math.max(tallest, values.get(i).get(j));
            tallestInRows[i] = tallest;
        }

        for (int i = 0; i < columns; i++) {
            int shortest = Integer.MAX_VALUE;
            for (int j = 0; j < rows; j++)
                shortest = Math.min(shortest, values.get(j).get(i));
            shortestInColumns[i] = shortest;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <  columns; j++) {
                int height = values.get(i).get(j);
                if (tallestInRows[i] == height && shortestInColumns[j] == height) 
                    saddlePoints.add(new MatrixCoordinate(i + 1, j + 1));
            }
        }
            
        return saddlePoints;
    }
}