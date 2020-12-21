package Vista;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorPanelEditar;
import Controlador.ControladorPanelGeneros;
import Modelo.Cartelera;
import Modelo.Pelicula;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class PanelEditar extends JPanel {

	private JButton btnVolver;
	private JButton btnEditar;
	private JButton btnInsertar;
	private JButton btnEliminarPeli;
	private JComboBox comboBoxPelis;
	private JLabel lblGeneros;
	private ControladorPanelGeneros controladorPanelGeneros;
	private JTextField txt_seleccion;
	private static JList lista_pelis;
	String resultado="";
	static String seleccion;
	private static Pelicula[] peliculas = new Pelicula[16];
	private JTextField pelisGeneroEdit;
	private JTextField editTitulo;
	private JTextField editGenero;
	private JTable table;
	private JTextField editDuracion;
	

	public PanelEditar(ControladorPanelEditar ControladorPanelEditar) {

	
		this.setSize(593, 439);
	

		 //ARRAY DE PELICULAS
		
		Pelicula[] peliculas=  Cartelera.getPeliculas();
		

		// ARRAYLIST PARA PARA PELIS SELECCIONADAS
		ArrayList <Pelicula> pelis_seleccion = new ArrayList<>();

		this.controladorPanelGeneros = controladorPanelGeneros;

		setLayout(null);

		// ---------------------------Ventana----------------------------------------------
		lblGeneros = new JLabel("EDITAR PELICULAS Y GENERO");
		lblGeneros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGeneros.setBounds(132, 29, 252, 23);
		add(lblGeneros);
		
		String col[] = {"Titulo","Genero","Duración"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	
		

	    for (Pelicula pelicula : peliculas ) {
	    	
	    	String saberhora = pelicula.getDuracion() + "";
	        String horadrama = saberhora.substring(0, saberhora.indexOf("."));
	        String mindrama = saberhora.substring(saberhora.indexOf(".")).substring(1);
	    	
	    	Object[] objs = {pelicula.getTitulo(),pelicula.getGenero(),horadrama+" h "+ mindrama +" minutos"};

			tableModel.addRow(objs);
	    }
	    

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorPanelEditar.accionadoBottonVolverPanelEditar();
			}
		});
		btnVolver.setBounds(318, 355, 126, 23);
		add(btnVolver);
		
		


		
		
		btnEditar = new JButton("Modificar");
		btnEditar.setBounds(318, 206, 126, 23);
		add(btnEditar);
		
		btnInsertar = new JButton("Insertar nueva");
	
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] info= new String[3];
				info[0]=editTitulo.getText();
				info[1]=editGenero.getText();
				info[2]=editDuracion.getText();
				
				tableModel.addRow(info);
				
				
				
				editTitulo.setText("");
				editGenero.setText("");
				editDuracion.setText("");
				
			}
		});
		btnInsertar.setBounds(318, 250, 126, 23);
		add(btnInsertar);
		
		btnEliminarPeli = new JButton("Eliminar");
		btnEliminarPeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int fila= table.getSelectedRow();
				if(fila>=0) {
					tableModel.removeRow(fila);
				}else {
					JOptionPane.showMessageDialog(null, "Seleccionar fila para eliminar");
				}
			}
		});
		btnEliminarPeli.setBounds(318, 296, 126, 23);
		add(btnEliminarPeli);
		
		editTitulo = new JTextField();
		editTitulo.setBounds(355, 59, 117, 23);
		add(editTitulo);
		
		editGenero = new JTextField();
		editGenero.setBounds(355, 97, 117, 23);
		add(editGenero);
		
		editDuracion = new JTextField();
		editDuracion.setBounds(355, 141, 117, 20);
		add(editDuracion);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo");
		lblNewLabel.setBounds(299, 63, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("G\u00E9nero");
		lblNewLabel_1.setBounds(299, 101, 46, 14);
		add(lblNewLabel_1);

		JLabel lblDurac = new JLabel("Duraci\u00F3n");
		lblDurac.setBounds(299, 144, 49, 14);
		add(lblDurac);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 63, 256, 315);
		add(scrollPane);
		

		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int seleccionar = table.getSelectedRow();
				editTitulo.setText(String.valueOf(table.getValueAt(seleccionar,0)));
				editGenero.setText(String.valueOf(table.getValueAt(seleccionar,1)));
				editDuracion.setText(String.valueOf(table.getValueAt(seleccionar,2)));
			}
		});
		

		

	}
	
}