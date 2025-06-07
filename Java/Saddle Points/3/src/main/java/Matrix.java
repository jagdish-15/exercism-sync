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
            .map(i -> values.stream().mapToInt(row -> row.get(i)).min().orElse(Integer.MAX_VALUE))
            .toArray();

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