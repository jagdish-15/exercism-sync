import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.IntStream;

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

        int[] tallestInRows = values.stream()
            .mapToInt(row -> row.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE))
            .toArray();
            
        int[] shortestInColumns = IntStream.range(0, columns)
            .map(column -> values.stream().mapToInt(row -> row.get(column)).min().orElse(Integer.MAX_VALUE))
            .toArray();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column <  columns; column++) {
                int height = values.get(row).get(column);
                if (tallestInRows[row] == height && shortestInColumns[column] == height) 
                    saddlePoints.add(new MatrixCoordinate(row + 1, column + 1));
            }
        }
            
        return saddlePoints;
    }
}