package Controlador;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelPeliculas;
import Vista.Vista;
import Vista.PanelGeneros;



public class ControladorPanelPeliculas {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelPeliculas panelPeliculas;
	
	
	//Estos dos arrays tendran almacenadas las peliculas que selecciona el usuario
	private static ArrayList<Pelicula> peliculasSabado=new ArrayList <Pelicula>();
	private static ArrayList<Pelicula> peliculasDomingo=new ArrayList <Pelicula>();
	
	
	
	
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
		controlador.navegarPanelGeneros();
		
	}
	
	public void accionadoBotonAnadirPeliculas(JList lista_pelis) {
		modelo.accionadoBotonAnadirPanelPeliculas(lista_pelis,controlador);
		
	}


	public static void setPeliculasSabado(ArrayList<Pelicula> peliculasSabado) {
		ControladorPanelPeliculas.peliculasSabado = peliculasSabado;
	}

	public static void setPeliculasDomingo(ArrayList<Pelicula> peliculasDomingo) {
		ControladorPanelPeliculas.peliculasDomingo = peliculasDomingo;
	}

	public static ArrayList<Pelicula> getPeliculasSabado() {
		return peliculasSabado;
	}

	

	public static ArrayList<Pelicula> getPeliculasDomingo() {
		return peliculasDomingo;
	}
	
	public PanelPeliculas makePanelPeliculas(ControladorPanelPeliculas controladorPeliculas) {
		return new PanelPeliculas(controladorPeliculas);
	}


}