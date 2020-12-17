package Controlador;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Modelo.Cartelera;
import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelPeliculas;
import Vista.Vista;
import Vista.PanelGeneros;



public class ControladorPanelPeliculas {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Cartelera cartelera;
	private Controlador controlador;
	private PanelPeliculas panelPeliculas;

	
	public ControladorPanelPeliculas(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelPeliculas(int genero) {
		this.panelPeliculas = new PanelPeliculas(this);
		this.vista.mostrarPanel(this.panelPeliculas);
		System.out.println("Este es el genero seleccionado: "+genero);
		//Cargar las peliculas del genero seleccionado	
	}
	
	
	public void accionadoBotonVolverPanelPeliculas() {
		this.controlador.navegarPanelGeneros();
		
	}
	
	public void accionadoBotonAnadirPeliculas(JList lista_pelis) {
		this.modelo.accionadoBotonAnadirPanelPeliculas(lista_pelis,controlador);
		
		
	}

	
	public static PanelPeliculas makePanelPeliculas(ControladorPanelPeliculas controladorPeliculas) {
		return new PanelPeliculas(controladorPeliculas);
	}


}