package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

import Controlador.Controlador;
import Controlador.ControladorPanelPeliculas;
import Controlador.ControladorPanelResumen;
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.PanelPeliculas;
import Vista.PanelResumen;
import Vista.Vista;


public class Modelo {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelGeneros panelGeneros;
	private PanelBienvenida panelBienvenida;
	private PanelPeliculas panelPelciulas;
	private static ArrayList<Pelicula> peliculasSabado=new ArrayList <Pelicula>();
	private static ArrayList<Pelicula> peliculasDomingo=new ArrayList <Pelicula>();
	
	
	//metodo que escribi en el fichero de logs los errores que le introduzcamos por parámetro
	public  void escribirErrorEnLog(String error) {
		
		try {
			FileWriter fr;
			File fichero=new File("errores.log");
			fr = new FileWriter(fichero,true);
			BufferedWriter br= new BufferedWriter(fr);	//se crea el buffer para escibir
			Date date = new Date(1);//revisar el 1, si no daba error
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			System.out.println(formatter.format(date));
			br.write("["+formatter.format(date)+"]-> "+error); 	
			br.newLine();//escribimos
			br.close(); 		//cerramos el buffer
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error al escribir en el fichero de errores");
			e.printStackTrace();
		}	 
	}
	
	public void delay3sec(int miliseg) {
	
		//Parar ejecucion durante 3 segundos y Mostrar Panel de Login
		
		try {
			Thread.sleep(miliseg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			escribirErrorEnLog(e.toString());
			e.printStackTrace();
		}	
		
		
	}
	
	public int minutosTotalesSabado() {
		int minutosTotales=0;
		for(int i=0;i<peliculasSabado.size();i++) {
			minutosTotales=(int) (minutosTotales+peliculasSabado.get(i).getDuracion());
		}
			
		return minutosTotales;
		
		
	}
	public int minutosTotalesDomingo() {
		int minutosTotales=0;
		for(int i=0;i<peliculasDomingo.size();i++) {
			minutosTotales=(int) (minutosTotales+peliculasDomingo.get(i).getDuracion());
		}
		
		
		return minutosTotales;
		
		
	}
	public void accionadoBotonAnadirPanelPeliculas(JList lista_pelis, Controlador controlador) {
		Pelicula[] peliculas=Cartelera.getPeliculas();
		//JList lista_pelis=PanelPeliculas.getLista_pelis();
		System.out.println((String)lista_pelis.getSelectedValue());
		

		if(lista_pelis.getSelectedValue()==null) {
			
			System.out.println("No has seleccionado ninguna pelicula");
			
		}
		else {
			String titulo;
			
			for(int i=0;i<peliculas.length;i++) {
				titulo=peliculas[i].getTitulo();
				//System.out.println(titulo+"  "+(String)lista_pelis.getSelectedValue());
				
				if(titulo.toString().trim().equals(lista_pelis.getSelectedValue().toString().trim())) {
					
					
					//Para que se pueda añadir una pelicula tiene que sumar menos de 8horas el sabado completo (480minutos)
					if((peliculas[i].getDuracion()+minutosTotalesSabado())<480){
						peliculasSabado.add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Sabado-> "+peliculasSabado.size());
						System.out.println("Minutos-> "+minutosTotalesSabado());
						
						
					}
					else if((peliculas[i].getDuracion()+minutosTotalesDomingo())<360){
						peliculasDomingo.add(peliculas[i]);
						controlador.navegarPanelGeneros();
						System.out.println("Peliculas Domingo-> "+peliculasDomingo.size());
						System.out.println("Minutos-> "+minutosTotalesDomingo());
						
					}
					else {
						 panelPelciulas.mostrar_error_peli();
						//JOptionPane.showMessageDialog(null, "No se puede introducir la pelicula, porque no hay tiempo");
						controlador.navegarPanelResumen();
					}
					
					
				}
				
			}
			
		}
	}

	
	public String generar_resumen() {
		int horas,minutos;
		String resumen="";

		resumen =resumen+"Sábado: \n";
		
		for(int i=0;i<peliculasSabado.size();i++) {
			horas=(int) Math.floor((peliculasSabado.get(i).getDuracion())/60);
			minutos=(int) Math.round((peliculasSabado.get(i).getDuracion())%60);
		
		resumen=resumen+peliculasSabado.get(i).getTitulo()+"-> "+horas+"h "+minutos+"m \n";
		
		}
		
		resumen =resumen+"\nDomingo: \n";
	
		for(int i=0;i< peliculasDomingo.size();i++) {
		horas=(int) Math.floor(( peliculasDomingo.get(i).getDuracion())/60);
		minutos=(int) Math.round(( peliculasDomingo.get(i).getDuracion())%60);
		
		resumen=resumen+ peliculasDomingo.get(i).getTitulo()+"-> "+horas+"h "+minutos+"m \n";
		

		
	}
	return resumen;
	
}

}
