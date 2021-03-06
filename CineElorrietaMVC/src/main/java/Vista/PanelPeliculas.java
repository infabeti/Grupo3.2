package Vista;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Modelo.Cartelera;
import Modelo.Modelo;
import Modelo.Pelicula;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelPeliculas extends JPanel {
	private JButton btnAnadirPelicula;
	private JLabel lblGenero;
	private JScrollPane scrollPane;
	private static JList lista_pelis;
	private JPanel txtGenero;
	DefaultListModel modelo_lista;
	private Modelo modelo;
	private Controlador controlador;
	
	
	/**
	 * Create the panel.
	 */
	public PanelPeliculas(ControladorPanelPeliculas controladorPanelPeliculas) {
		setLayout(null);
		
		btnAnadirPelicula = new JButton("A\u00F1adir Pelicula");
		btnAnadirPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorPanelPeliculas.accionadoBotonAnadirPeliculas(lista_pelis);
			}
		});
		btnAnadirPelicula.setBounds(47, 314, 168, 23);
		add(btnAnadirPelicula);
		
		lblGenero = new JLabel("Genero Seleccionado:");
		lblGenero.setBounds(37, 45, 141, 14);
		add(lblGenero);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 114, 168, 137);
		add(scrollPane);
		
		lista_pelis = new JList();
		lista_pelis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lista_pelis);
		
		txtGenero = new JPanel();
		txtGenero.setBounds(221, 45, 156, 23);
		add(txtGenero);
		modelo_lista = new DefaultListModel();
		
		
		 Pelicula[] peliculas=Cartelera.getPeliculas();
		 
		 int genero=Integer.parseInt(PanelGeneros.getSeleccion());
		
		 
		 
		 
		modelo_lista.clear();
		for (int i = 0; i < peliculas.length; i++) {
			if (peliculas[i].getGenero() == genero) {
				String resultado = "";
				System.out.println(peliculas[i].getTitulo());
				resultado += peliculas[i].getTitulo() + "\n";
				modelo_lista.addElement(resultado);
				
				
			}
		}
		
		 
		lista_pelis.setModel(modelo_lista);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelPeliculas.accionadoBotonVolverPanelPeliculas();
			}
		});
		btnVolver.setBounds(308, 314, 89, 23);
		add(btnVolver);
		
		

	}
	public static void mostrar_error_peli() {
		JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
	}

	public static JList getLista_pelis() {
		return lista_pelis;
	}

	public void setLista_pelis(JList lista_pelis) {
		this.lista_pelis = lista_pelis;
	}

	public JPanel getTxtGenero() {
		return txtGenero;
	}

	public void setTxtGenero(JPanel txtGenero) {
		this.txtGenero = txtGenero;
	}

	public DefaultListModel getModelo() {
		return modelo_lista;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo_lista = modelo;
	}
}
