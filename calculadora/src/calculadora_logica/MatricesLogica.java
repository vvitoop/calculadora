package calculadora_logica;

public class MatricesLogica {

    public static double[][] sumaMatrices(double[][] matriz1, double[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return null;
        }

        double[][] resultado = new double[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }

    public static double[][] restaMatrices(double[][] matriz1, double[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return null;
        }

        double[][] resultado = new double[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }

        return resultado;
    }

    public static double[][] multiplicacionEscalarPorMatriz(double escalar, double[][] matriz) {
        double[][] resultado = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[i][j] = escalar * matriz[i][j];
            }
        }
        return resultado;
    }

    public static double[][] productoMatrices(double[][] matriz1, double[][] matriz2) {
        if (matriz1[0].length != matriz2.length) {
            return null;
        }

        double[][] resultado = new double[matriz1.length][matriz2[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    public static double[][] inversaMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];
        double[][] copia = new double[n][n];

        for (int i = 0; i < n; i++) {
            identidad[i][i] = 1;
            for (int j = 0; j < n; j++) {
                copia[i][j] = matriz[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            double pivote = copia[i][i];
            if (pivote == 0) {
                return null;
            }
            for (int j = 0; j < n; j++) {
                copia[i][j] /= pivote;
                identidad[i][j] /= pivote;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = copia[k][i];
                    for (int j = 0; j < n; j++) {
                        copia[k][j] -= factor * copia[i][j];
                        identidad[k][j] -= factor * identidad[i][j];
                    }
                }
            }
        }

        return identidad;
    }

    public static double determinanteMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] copia = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copia[i][j] = matriz[i][j];
            }
        }
        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivotIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(copia[j][i]) > Math.abs(copia[pivotIndex][i])) {
                    pivotIndex = j;
                }
            }
            if (pivotIndex != i) {
                double[] temp = copia[i];
                copia[i] = copia[pivotIndex];
                copia[pivotIndex] = temp;
                det *= -1;
            }
            if (copia[i][i] == 0) {
                return 0;
            }
            det *= copia[i][i];
            for (int j = i + 1; j < n; j++) {
                copia[i][j] /= copia[i][i];
            }
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    copia[j][k] -= copia[j][i] * copia[i][k];
                }
            }
        }
        return det;
    }
}