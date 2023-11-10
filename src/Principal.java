import javax.swing.SwingUtilities;

public class Principal {
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                Ventana ventana = new Ventana();
	                ventana.setVisible(true);
	            }
	        });
	    }
}
