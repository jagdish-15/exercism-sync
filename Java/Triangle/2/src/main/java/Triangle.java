import java.util.HashSet;
import java.util.ArrayList;

class Triangle {
    private HashSet<Double> sideSet;
    private ArrayList<Double> sides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new TriangleException();
        }

        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sideSet = new HashSet<>(sides);
        
        if (!isValidTriangle()) {
            throw new TriangleException();
        }
    }

    private boolean isValidTriangle() {
        for (int i = 0; i < 3; i++) {
            if (sides.get(i) >= sides.get((i + 1) % 3) + sides.get((i + 2) % 3)) {
                return false;
            }
        }
        return true;
    }

    boolean isEquilateral() {
        return sideSet.size() == 1;
    }

    boolean isIsosceles() {
        return sideSet.size() <= 2;
    }

    boolean isScalene() {
        return sideSet.size() == 3;
    }
}