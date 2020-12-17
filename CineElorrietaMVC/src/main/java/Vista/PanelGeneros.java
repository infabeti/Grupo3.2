package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelGeneros;
import Modelo.Cartelera;
import Modelo.Pelicula;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class PanelGeneros extends JPanel {

	private JButton btnVolver;
	private JLabel lblGeneros;
	private ControladorPanelGeneros controladorPanelGeneros;
	private JTextField txt_seleccion;
	String resultado="";
	static String seleccion;
	//private static Pelicula[] peliculas = new Pelicula[16];
	private Pelicula[] peliculas=Cartelera.getPeliculas();
	DefaultListModel modelo = new DefaultListModel();
	

	public PanelGeneros(ControladorPanelGeneros controladorPanelGeneros) {
		this.controladorPanelGeneros = controladorPanelGeneros;

		setLayout(null);

		// ---------------------------Ventana----------------------------------------------
		lblGeneros = new JLabel("PANEL GENEROS");
		lblGeneros.setBounds(61, 35, 115, 14);
		add(lblGeneros);

		JTextPane textPaneGeneros = new JTextPane();
		textPaneGeneros.setBounds(61, 63, 168, 137);
		add(textPaneGeneros);
		textPaneGeneros.setText("1. DRAMA\n2. COMEDIA\r\n3. TERROR\r\n4. CIENCIA FICCION");

		JLabel lbl_SeleccionGenero = new JLabel("Genero seleccionado");
		lbl_SeleccionGenero.setBounds(61, 227, 149, 14);
		add(lbl_SeleccionGenero);

		txt_seleccion = new JTextField();
		txt_seleccion.setBounds(61, 252, 168, 37);
		add(txt_seleccion);
		txt_seleccion.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 63, 168, 137);
		add(scrollPane);
		
		JList lista_pelis = new JList();
		lista_pelis.setEnabled(false);
		scrollPane.setViewportView(lista_pelis);
		
		//necesario crear un modelo con el que llenar el jlist
		JButton btnAnadir = new JButton("Continuar");
		btnAnadir.setEnabled(false);
		
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelGeneros.accionadoBotonSeleccionarPanelGeneros(Integer.parseInt(seleccion));
				
				
			}
		});
		
		JButton btnElegir = new JButton("Seleccionar");
		btnElegir.setBounds(61, 304, 168, 23);
		btnElegir.addActionListener(new ActionListener() {		

			public void actionPerformed(ActionEvent arg0) {
				
				seleccion = txt_seleccion.getText();// recogemos el dato de seleccion de genero

				if (seleccion.equals("1")||seleccion.equals("2")||seleccion.equals("3")||seleccion.equals("4")) {
					modelo.clear();//vaciamos el jlist
					mostar_pelis_genero(Integer.parseInt(seleccion));
					btnAnadir.setEnabled(true);

				}
				
				if ((!seleccion.equals("4")&&(!seleccion.equals("3"))&&(!seleccion.equals("2"))&&(!seleccion.equals("1"))))  {
					JOptionPane.showMessageDialog(null, "Selección incorrecta");
					txt_seleccion.setText("");
					
				}
						
				lista_pelis.setModel(modelo);
			}
		});

		add(btnElegir);
	
		JLabel lblPelis = new JLabel("PEL\u00CDCULAS DISPONIBLES");
		lblPelis.setBounds(271, 35, 135, 14);
		add(lblPelis);

		

		btnAnadir.setBounds(271, 304, 168, 23);
		add(btnAnadir);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 372, 89, 23);
		add(btnVolver);


		initializeEvents();

	}
	 private void mostar_pelis_genero(int genero) {
			for (int i = 0; i < peliculas.length; i++) {
				if (peliculas[i].getGenero() == genero) {
					String resultado = "";
					System.out.println(peliculas[i].getTitulo());
					resultado += peliculas[i].getTitulo() + "\n";
					modelo.addElement(resultado);
					
				}
			}
	
		}
		 

	private void initializeEvents() {
		this.btnVolver.addActionListener(listenerBotonVolver(this.controladorPanelGeneros));
	}

	private ActionListener listenerBotonVolver(ControladorPanelGeneros controladorPanelGeneros) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Ejecutando evento Boton Volver");
				controladorPanelGeneros.accionadoBottonVolverPanelGeneros();
			}
		};
	}


	public static String getSeleccion() {
		return seleccion;
	}

	public static void setSeleccion(String seleccion) {
		PanelGeneros.seleccion = seleccion;
	}
	

	
	

	
}

