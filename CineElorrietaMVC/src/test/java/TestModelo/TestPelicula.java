package TestModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Pelicula;

public class TestPelicula {
	
	private int genero=1;
	private String titulo= "Handia";
	private double duracion=114;
	private Pelicula peli=new Pelicula( genero, titulo,  duracion);
	

	@Test
	public void testPeli() {
		assertEquals(peli.getGenero(),1);
		assertEquals(peli.getTitulo(),"Handia");
		assertEquals(peli.getDuracion(),114,0);
		
	}
	@Test
	public void setGenero() {
		peli.setGenero(1);
		assertEquals(peli.getGenero(),1);
	}
	@Test
	public void setTitulo() {
		peli.setTitulo("Handia");
		assertEquals(peli.getTitulo(),"Handia");
	}
	@Test
	public void setDuracion() {
		peli.setDuracion(114);
		assertEquals(peli.getDuracion(),114,0.01);
	}

}
