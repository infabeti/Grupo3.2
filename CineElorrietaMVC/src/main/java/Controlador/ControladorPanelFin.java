package Controlador;

import Modelo.Modelo;
import Vista.PanelFin;
import Vista.PanelResumen;
import Vista.Vista;

public class ControladorPanelFin {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelFin panelFin;
	
	public ControladorPanelFin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelFin() {
		this.panelFin = new PanelFin(this);
		this.vista.mostrarPanel(this.panelFin);
		
		
		
		
		
		//se cierra la ventana
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Controlador.escribirErrorEnLog(e.toString());
			e.printStackTrace();
		}
		System.exit(0);
	
	}
	
	public PanelFin makePanelFin(ControladorPanelFin controladorFin) {
		return new PanelFin(controladorFin);
	}

}
