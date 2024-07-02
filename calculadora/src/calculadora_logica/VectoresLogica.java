package calculadora_logica;

public class VectoresLogica {

	public static void main(String[] args) {
		

	}
	
	public static double[] sumaVectores(double[] vector1, double[] vector2) {
       
        if (vector1.length != vector2.length) {
            return null;
        }

        
        double[] resultado = new double[vector1.length];

        
        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] + vector2[i];
        }

        return resultado;
    }
	
	public static double[] restaVectores(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            return null;
        }

        double[] resultado = new double[vector1.length];

        
        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] - vector2[i];
        }

        return resultado;
    }
	
	public static double[] multiplicacionEscalarPorVector(double escalar, double[] vector) {
	    double[] resultado = new double[vector.length];
	    for (int i = 0; i < vector.length; i++) {
	        resultado[i] = escalar * vector[i];
	    }
	    return resultado;
	}
	
	public static double productoEscalar(double[] vector1, double[] vector2) {
	    if (vector1.length != vector2.length) {
	        return Double.NaN;
	    }
	    
	    double producto = 0;
	    for (int i = 0; i < vector1.length; i++) {
	        producto += vector1[i] * vector2[i];
	    }
	    
	    return producto;
	}
	
	public static boolean validarDimension(Vector3D v1, Vector3D v2) {
	    return v1.getDimension() == 3 && v2.getDimension() == 3;
	}


}
