package calculadora_logica;

public class BasicasLogica {

	public static void main(String[] args) {
		

	}
	
	public static double suma(double a, double b) {
        return a + b;
    }

    public static double resta(double a, double b) {
        return a - b;
    }

    public static double multiplicacion(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            return Double.NaN; 
        } else {
            return a / b;
        }
    }
    
    public static double potencia(double a, double b) { 
    	if (a == 0 && b < 0) {
    		return Double.NaN;
    	} else {
    		return Math.pow(a, b);
    	}
    }
    
    public static double raiz(double a, double b) { // a = radicando, b = radical
    	if (a < 0 || b == 0) {
    		return Double.NaN;
    	} else {
    		return Math.pow(a, 1.0 / b);
    	}
    }

}
