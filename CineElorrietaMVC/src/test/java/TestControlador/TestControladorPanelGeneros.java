package TestControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;
import org.junit.Test;
import org.junit.Test;

import Controlador.Controlador;
import Controlador.ControladorPanelGeneros;
import Modelo.Modelo;
import Vista.PanelGeneros;
import Vista.Vista;

public class TestControladorPanelGeneros {

	private ControladorPanelGeneros controladorGeneros;
	private Modelo modeloMock = mock(Modelo.class);
	private Vista vistaMock = mock(Vista.class);
	private Controlador controladorMock = mock(Controlador.class);
	private PanelGeneros panelGeneroMock = mock(PanelGeneros.class);
	private ControladorPanelGeneros spyControladorGeneros = spy(new ControladorPanelGeneros(modeloMock, vistaMock, controladorMock)); 
	//usamos el spy para 'trampear' el

	//testeo del metodo mostrar panelGeneros
	@Test
	public void mostrarPanelGenerosTest() {
		doReturn(panelGeneroMock)
	    	.when(spyControladorGeneros)
	    	.makePanelGeneros(any( ControladorPanelGeneros.class)); 
		
		spyControladorGeneros.mostrarPanelGeneros();
		verify(vistaMock, times(1)).mostrarPanel(panelGeneroMock);
	}

	//testeo del boton que nos lleva al panel de bienvenida
	@Test
	public void accionadoBottonVolverPanelProductosTest() {
		controladorGeneros = new ControladorPanelGeneros(modeloMock,
				vistaMock, controladorMock);
		
		controladorGeneros.accionadoBottonVolverPanelGeneros();
		
		verify(controladorMock, times(1)).navegarPanelBienvenida();
	}
	//testeo del boton que nos lleva a la pagina de seleccion de peliculas
	@Test
	public void accionadoBotonSeleccionarPanelGeneros() {
		controladorGeneros = new ControladorPanelGeneros(modeloMock,
				vistaMock, controladorMock);
		
		controladorGeneros.accionadoBotonSeleccionarPanelGeneros(1);
		
		verify(controladorMock, times(1)).navegarPanelPeliculas(1);
	}

}
