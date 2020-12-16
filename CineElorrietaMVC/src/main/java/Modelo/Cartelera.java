package Modelo;

public class Cartelera {

	private static Pelicula[] peliculas = new Pelicula[16];
	

	public Cartelera() {
		super();
	
	}


	public static Pelicula[] getPeliculas() {
		return peliculas;
	}


	public static void setPeliculas(Pelicula[] peliculas) {
		Cartelera.peliculas = peliculas;
	}
	

	public  static  void cargar_pelis() {
		
		peliculas[0] = new Pelicula(1, "Handia", 116);
		peliculas[1] = new Pelicula(1, "La lista de Schindler", 197);
		peliculas[2] = new Pelicula(1, "Cadena Perpetua", 142);
		peliculas[3] = new Pelicula(1, "Million Dollar Baby", 133);

		peliculas[4] = new Pelicula(2, "Scary movie", 90);
		peliculas[5] = new Pelicula(2, "El gran Lebowsky", 119);
		peliculas[6] = new Pelicula(2, "La vida de Brian", 94);
		peliculas[7] = new Pelicula(2, "Aterriza como puedas", 117);

		peliculas[8] = new Pelicula(3, "Psicosis", 109);
		peliculas[9] = new Pelicula(3, "El resplandor", 146);
		peliculas[10] = new Pelicula(3, "Dracula", 155);
		peliculas[11] = new Pelicula(3, "Cisne negro", 100);

		peliculas[12] = new Pelicula(4, "2001: Odisea en el espacio", 142);
		peliculas[13] = new Pelicula(4, "La novia de Frankenstein", 75);
		peliculas[14] = new Pelicula(4, "El planeta de los simios", 115);
		peliculas[15] = new Pelicula(4, "Alien, el octavo pasajero", 117);

	
	}
}
