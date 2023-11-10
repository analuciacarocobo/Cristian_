
public class Persona {
	 private String documento;
	    private String nombre;
	    private int edad;
	    private double peso;
	    private double talla;

	    public Persona(String documento, String nombre, int edad, double peso, double talla) {
	        this.documento = documento;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.peso = peso;
	        this.talla = talla;
	    }
	    public double calcularIMC() {
	        return peso / (talla * talla);
	    }

	    public String obtenerConclusionIMC() {
	        double imc = calcularIMC();
	        if (imc < 18) {
	            return "Anorexia";
	        } else if (imc >= 18 && imc < 20) {
	            return "Delgadez";
	        } else if (imc >= 20 && imc < 27) {
	            return "Normalidad";
	        } else if (imc >= 27 && imc < 30) {
	            return "Obesidad (grado 1)";
	        } else if (imc >= 30 && imc < 35) {
	            return "Obesidad (grado 2)";
	        } else if (imc >= 35 && imc < 40) {
	            return "Obesidad (grado 3)";
	        } else {
	            return "Obesidad mórbida";
	        }
	    }
	    @Override
	    public String toString() {
	        return "Documento: " + documento + ", Nombre: " + nombre + ", Edad: " + edad +
	               ", Peso: " + peso + ", Talla: " + talla;
	    }
}
