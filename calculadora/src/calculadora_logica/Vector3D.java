package calculadora_logica;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Método para calcular el producto vectorial
    public Vector3D productoVectorial(Vector3D v) {
        double resultadoX = this.y * v.z - this.z * v.y;
        double resultadoY = this.z * v.x - this.x * v.z;
        double resultadoZ = this.x * v.y - this.y * v.x;
        return new Vector3D(resultadoX, resultadoY, resultadoZ);
    }

	public int getDimension() {
		// TODO Auto-generated method stub
		return 0;
	}
}