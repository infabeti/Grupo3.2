package Controlador;

import javax.swing.DefaultListModel;

import Modelo.Modelo;
import Modelo.Pelicula;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.PanelEditar;
import Vista.Vista;

public class ControladorPanelEditar {
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelEditar paneleditar;
	
	public ControladorPanelEditar(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelEditar() {
		/*this.panelGeneros = new PanelGeneros(this);
		this.vista.mostrarPanel(this.panelGeneros);*/
	}
	
	public void accionadoBottonVolverPanelGeneros() {
		this.controlador.navegarPanelBienvenida();
	}
	public void accionadoBotonSeleccionarPanelGeneros(int genero) {

		this.controlador.navegarPanelPeliculas(genero);
	}
	public PanelGeneros makePanelGeneros(ControladorPanelGeneros controladorGeneros) {
		return new PanelGeneros(controladorGeneros);
	}

}
