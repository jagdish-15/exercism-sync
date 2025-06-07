class ComplexNumber {
    private double real;
    private double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    double getReal() {
        return this.real;
    }

    double getImaginary() {
        return this.imaginary;
    }

    double abs() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
    }

    ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.getReal(), this.imaginary + other.getImaginary());
    }

    ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.real - other.getReal(), this.imaginary - other.getImaginary());
    }

    ComplexNumber multiply(ComplexNumber other) {
        double real = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double imaginary = this.imaginary * other.getReal() + this.real * other.getImaginary();
        return new ComplexNumber(real, imaginary);
    }

    ComplexNumber multiply(double factor) {
        return new ComplexNumber(factor * this.real, factor * this.imaginary);
    }

    ComplexNumber divide(ComplexNumber other) {
        double divisor = Math.pow(other.abs(), 2);
        double real = (this.real * other.getReal() + this.imaginary * other.getImaginary()) / divisor;
        double imaginary = (this.imaginary * other.getReal() - this.real * other.getImaginary()) / divisor;
        return new ComplexNumber(real, imaginary);
    }

    ComplexNumber divide(double divisor) {
        return new ComplexNumber(this.real / divisor, this.imaginary / divisor);
    }

    ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    ComplexNumber exponentialOf() {
        double factor = Math.exp(this.real);
        double real = factor * Math.cos(this.imaginary);
        double imaginary = factor * Math.sin(this.imaginary);
        return new ComplexNumber(real, imaginary);
    }
}