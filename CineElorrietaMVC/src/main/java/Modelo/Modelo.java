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
import Vista.PanelBienvenida;
import Vista.PanelGeneros;
import Vista.Vista;


public class Modelo {
	
	private Modelo modelo;
	private Vista vista;
	private Controlador controlador;
	private PanelGeneros panelGeneros;
	private PanelBienvenida panelBienvenida;
	private static ArrayList<Pelicula> peliculasSabado=new ArrayList <Pelicula>();
	private static ArrayList<Pelicula> peliculasDomingo=new ArrayList <Pelicula>();
	int minutosTotales=0;
	
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
	



}
