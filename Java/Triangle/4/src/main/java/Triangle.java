import java.util.Arrays;

class Triangle {
    private long distinctSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        double[] sides = {side1, side2, side3};
        
        if (!isValidTriangle(sides)) {
            throw new TriangleException();
        }
        
        distinctSides = Arrays.stream(sides)
            .distinct()
            .count();
    }

    private boolean isValidTriangle(double[] sides) {
        for (int i = 0; i < 3; i++) {
            if (sides[i] >= sides[(i + 1) % 3] + sides[(i + 2) % 3]) {
                return false;
            }
        }
        return true;
    }

    boolean isEquilateral() {
        return distinctSides == 1;
    }

    boolean isIsosceles() {
        return distinctSides <= 2;
    }

    boolean isScalene() {
        return distinctSides == 3;
    }
}