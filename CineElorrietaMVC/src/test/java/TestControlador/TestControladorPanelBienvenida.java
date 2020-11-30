package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelBienvenida;
import Controlador.ControladorPanelGeneros;
import Modelo.Modelo;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;

public class TestControladorPanelBienvenida {

	private ControladorPanelBienvenida controladorBienve;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private PanelBienvenida panelBienvMock = mock(PanelBienvenida.class);
	private ControladorPanelBienvenida spyControladorGeneros = spy(new ControladorPanelBienvenida(modeloMock, vistaMock, controladorMock)); 

	@Test
	public void mostrarPanelBienvenida() {
		doReturn(panelBienvMock)
	    	.when(spyControladorGeneros)
	    	.makePanelBienv(any( ControladorPanelBienvenida.class)); 
		
		spyControladorGeneros.mostrarPanelBienvenida();
		verify(vistaMock, times(1)).mostrarPanel(panelBienvMock);
	}
	@Test
	public void accionadoBottonMostrarPanelGeneros() {
		controladorBienve = new ControladorPanelBienvenida(modeloMock,
				vistaMock, controladorMock);
		
		controladorBienve.accionadoBottonMostrarPanelGeneros();
		
		verify(controladorMock, times(1)).navegarPanelPeliculas(1);
	}

}
