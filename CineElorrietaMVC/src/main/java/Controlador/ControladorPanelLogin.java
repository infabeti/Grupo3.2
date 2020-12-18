package Controlador;

import Modelo.Modelo;
import Vista.PanelLogin;
import Vista.Vista;

public class ControladorPanelLogin {
	@SuppressWarnings("unused")
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelLogin panelLogin;
	private final String usuario="usuario";
	private final String contrasena="12345";
	
	
	
	
	public ControladorPanelLogin(Modelo modelo, Vista vista, Controlador controlador) {
		this.modelo = modelo;
		this.vista = vista;
		this.controlador = controlador;	
	}
	
	public void mostrarPanelLogin() {
		this.panelLogin = new PanelLogin(this);
		this.vista.mostrarPanel(this.panelLogin);
	}
	

	public PanelLogin makePanelLogin(ControladorPanelLogin controladorLogin) {
		return new PanelLogin(controladorLogin);
	}

	public void accionadoBotonEntrarPanelLogin(String usuario2, String pass) {
		System.out.println("Ejecutando evento Boton Entrar");
		
		if(usuario2.equals(this.usuario) && pass.equals(this.contrasena)) {		
			System.out.println("Usuario/Contrase�a correctos");
			this.controlador.navegarPanelGeneros();
		}
		else {
			System.out.println("Usuario/contrase�a incorrectos");
			panelLogin.mostrarLoginError();
		}
		
	}
	
	
}
