import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame implements Serializable{
	 private static final long serialVersionUID = 1L;
	 private JTextField txtDocumento, txtNombre, txtEdad, txtPeso, txtTalla;
	    private JButton btnCalcularIMC, btnRegistrar, btnCalcularPromedio, btnListaPersonas;
	    private JTextArea areaResultado;
	    private Logica logica;

	    public Ventana() {
	        logica = new Logica();
	        
	        setTitle("Calculadora de IMC");
	        setSize(400, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new FlowLayout());

	       
	        JLabel etiTitulo = new JLabel("Calculadora de IMC");
	        txtDocumento = new JTextField(10);
	        txtNombre = new JTextField(10);
	        txtEdad = new JTextField(10);
	        txtPeso = new JTextField(10);
	        txtTalla = new JTextField(10);
	        btnCalcularIMC = new JButton("Calcular IMC");
	        btnRegistrar = new JButton("Registrar");
	        btnCalcularPromedio = new JButton("Calcular Promedio IMC");
	        btnListaPersonas = new JButton("Lista de Personas");
	        areaResultado = new JTextArea(10, 30);
	        JScrollPane scrollPane = new JScrollPane(areaResultado);
	        
	        
	        add(etiTitulo);
	        add(new JLabel("Documento:"));
	        add(txtDocumento);
	        add(new JLabel("Nombre:"));
	        add(txtNombre);
	        add(new JLabel("Edad:"));
	        add(txtEdad);
	        add(new JLabel("Peso:"));
	        add(txtPeso);
	        add(new JLabel("Talla:"));
	        add(txtTalla);
	        add(btnCalcularIMC);
	        add(btnRegistrar);
	        add(btnCalcularPromedio);
	        add(btnListaPersonas);
	        add(scrollPane);
	        
	        btnCalcularIMC.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calcularIMC();
	            }
	        });

	        btnRegistrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                registrarPersona();
	            }
	        });

	        btnCalcularPromedio.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                calcularPromedioIMC();
	            }
	        });

	        btnListaPersonas.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                mostrarListaPersonas();
	            }
	        });
	    }

	    private void calcularIMC() {
	    	  String documento = txtDocumento.getText();
	          String nombre = txtNombre.getText();
	          int edad = Integer.parseInt(txtEdad.getText());
	          double peso = Double.parseDouble(txtPeso.getText());
	          double talla = Double.parseDouble(txtTalla.getText());

	          Persona persona = new Persona(documento, nombre, edad, peso, talla);

	          double imc = persona.calcularIMC();
	          String conclusion = persona.obtenerConclusionIMC();

	          areaResultado.setText("IMC: " + imc + " CONCLUSIÓN: " + conclusion);
	      }

	      private void registrarPersona() {
	          String documento = txtDocumento.getText();
	          String nombre = txtNombre.getText();
	          int edad = Integer.parseInt(txtEdad.getText());
	          double peso = Double.parseDouble(txtPeso.getText());
	          double talla = Double.parseDouble(txtTalla.getText());
	          
	          Persona persona = new Persona(documento, nombre, edad, peso, talla);

	          logica.registrarPersona(persona);

	          areaResultado.setText("Persona registrada:\n" + persona.toString());
	      }

	      private void calcularPromedioIMC() {
	          double promedioIMC = logica.calcularPromedioIMC();

	          areaResultado.setText("Promedio de IMC: " + promedioIMC);
	      }

	      private void mostrarListaPersonas() {
	          ArrayList<Persona> personas = logica.obtenerListaPersonas();
	          
	          for (Persona persona : personas) {
	              areaResultado.append(persona.toString() + "\n");
	          }
	      }
	  
	    }

