package Controlador;

import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;

public class ControladorPanelBienvenida {

	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelBienvenida panelBienvenida;
	
	
	public ControladorPanelBienvenida(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	public void mostrarPanelBienvenida() {
		this.panelBienvenida = new PanelBienvenida(this);
		this.vista.mostrarPanel(this.panelBienvenida);
		//para llamar al metodo de los 3 segundos y se lo pasamos como milisegundos
		this.modelo.delay3sec(3000);		
		this.controlador.navegarPanelLogin();
		
		
		
	}
	

	
	public void accionadoBottonMostrarPanelGeneros() {
		this.controlador.navegarPanelGeneros();
	}
	public PanelBienvenida makePanelBienv(ControladorPanelBienvenida controladorBienvenida) {
		return new PanelBienvenida(controladorBienvenida);
	}
}
