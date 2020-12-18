package Controlador;

import Modelo.Cartelera;
import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.PanelLogin;
import Vista.PanelPeliculas;
import Vista.PanelResumen;
import Vista.Vista;

public class ControladorPanelResumen {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Cartelera cartelera;
	private Controlador controlador;
	private PanelResumen panelResumen;
	
	public ControladorPanelResumen(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	//Muestra las peliculas del sabado y domingo con su duración
	public void mostrarPanelResumen() {
		this.panelResumen = new PanelResumen(this);
		this.vista.mostrarPanel(this.panelResumen);
		this.panelResumen.texto_resumen();
		
	}
		
	
	public void accionadoBotonRechazarPanelResumen() {
		this.controlador.navegarPanelGeneros();
		this.cartelera.getPeliculasSabado().removeAll(cartelera.getPeliculasSabado());
		this.cartelera.getPeliculasDomingo().removeAll(cartelera.getPeliculasDomingo());
		
	}
	
	public void accionadoBotonAceptarPanelResumen() {
		controlador.navegarPanelFin();
		
		
	}
	
	public PanelResumen makePanelResumen(ControladorPanelResumen controladorResumen) {
		return new PanelResumen(controladorResumen);
	}
	


}
