package calculadora_logica;

public class EcuacionesLogica {

    public static double[] resolverSistema2x2(double[][] A, double[] B) {
        double a1 = A[0][0], b1 = A[0][1], c1 = B[0];
        double a2 = A[1][0], b2 = A[1][1], c2 = B[1];

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            return null;
        }

        double x = (c1 * b2 - c2 * b1) / determinant;
        double y = (a1 * c2 - a2 * c1) / determinant;

        return new double[]{ x, y };
    }

    public static double[] resolverSistema3x3(double[][] A, double[] B) {
        // Implementar el método de resolución para 3x3
        // ...
        return null;
    }
}
