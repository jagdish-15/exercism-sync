import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Matrix {

    public List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        for (int i = 0; i < values.size(); i++) {
            int tallestInRow = 0;
            List<Integer> tallestColumns = new ArrayList<Integer>();
            for (int treeHeight: values.get(i)) {
                tallestInRow = treeHeight > tallestInRow ? treeHeight : tallestInRow;
            }
            for (int j = 0; j < values.get(i).size(); j++) {
                if (values.get(i).get(j) == tallestInRow) {
                    tallestColumns.add(j);
                } 
            }
            for (int k = 0; k < tallestColumns.size(); k++) {
                int column = tallestColumns.get(k);
                boolean isShortest = true;
                for (int j = 0; j < values.size(); j++) {
                    if (tallestInRow > values.get(j).get(column)) {
                        isShortest = false;
                        break;
                    }
                }
                if (isShortest) {
                    saddlePoints.add(new MatrixCoordinate(i + 1, column + 1));
                }
            }
            
        }
        return saddlePoints;
    }
}
