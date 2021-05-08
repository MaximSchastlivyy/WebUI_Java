package Lesson4;

public class Triangle {

    public Triangle() {
    }

    public static double triangleArea (double a, double b, double c) throws NotNegativeOrNullException {
        if (a <= 0 || b <= 0 || c <= 0) throw new NotNegativeOrNullException();
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
