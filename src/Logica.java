import java.util.ArrayList;

public class Logica {
	    private ArrayList<Persona> personas = new ArrayList<>();

	    public void registrarPersona(Persona persona) {
	        personas.add(persona);
	    }

	    public double calcularPromedioIMC() {
	        if (personas.isEmpty()) {
	            return 0.0;
	        }

	        double sumIMC = 0.0;
	        for (Persona persona : personas) {
	            sumIMC += persona.calcularIMC();
	        }
	        return sumIMC / personas.size();
	    }

	    public ArrayList<Persona> obtenerListaPersonas() {
	        return personas;
	    }
}
