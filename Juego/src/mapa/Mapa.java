package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;
	
	protected int[] cuadros;
	protected Cuadro[] cuadrosCatalogo;
	
	
	public Mapa(int ancho,int alto) {
		this.ancho=ancho;
		this.alto=alto;
		
		cuadros=new int[ancho*alto];
		generarMapa();
	}
	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();
	}
	
	protected void generarMapa() {
		
	}
	protected void cargarMapa(String ruta) {
		
	}
	public void actualizar() {
		
	}
	public void mostrar(final int compensacionX,final int compensacionY,final Pantalla pantalla) {
		pantalla.estableceDiferencia(compensacionX, compensacionY);
		
		int o= compensacionX >> 5; // /32
		int e= (compensacionX+pantalla.getAncho()+Cuadro.LADO)>> 5; // /32;
		int n= compensacionY>> 5; // /32;
		int s= (compensacionY+pantalla.getAlto()+Cuadro.LADO)>> 5;// /32;
		
		for (int y=n; y<s; y++) {
			for (int x=o; x<e; x++) {
				//obtenCuadro(x,y).mostrar(x, y, pantalla);
				if(x<0 || y<0 || x>=ancho || y>=alto) {
					Cuadro.VACIO.mostrar(x, y, pantalla);
				}else {
					cuadrosCatalogo[x+y*ancho].mostrar(x, y, pantalla);
				}
			}
			
		}
		
	}
	public Cuadro obtenCuadro(final int x,final int y) {
	
		if (x<0 || y<0 || x>=ancho || y>=alto) {
			return Cuadro.VACIO;
		}
		switch(cuadros[x+y*ancho]) {
			case 0:
				return Cuadro.SUELOSOLO;
			case 1:
				return Cuadro.SUELOIZQ;
			case 2:
				return Cuadro.SUELO;
			case 3:
				return Cuadro.SUELODER;
			case 4:
				return Cuadro.PLATAFORMAIZQ;
			case 5:
				return Cuadro.PLATAFORMA;
			case 6:
				return Cuadro.PLATAFORMADER;
			case 7:
				return Cuadro.BORDEAGUAIZQ;
			case 8:
				return Cuadro.AGUA;
			case 9:
				return Cuadro.BORDEAGUADER;
			case 10:
				return Cuadro.CUELLOSOLO;
			case 11:
				return Cuadro.PAREDIZQ;
			case 12:
				return Cuadro.PARED;
			case 13:
				return Cuadro.PAREDDER;
			case 14:
				return Cuadro.NUBEIZQ;
			case 15:
				return Cuadro.NUBEDER;
			case 16:
				return Cuadro.PLATAFORMASOLO;
			case 17:
				return Cuadro.PAREDAGUAIZQ;
			case 18:
				return Cuadro.BOTTOMAGUA;
			case 19:
				return Cuadro.PAREDAGUADER;
			case 20:
				return Cuadro.BOTTOMSOLO;
			case 21:
				return Cuadro.ESQUINAIZQ;
			case 22:
				return Cuadro.BOTTOM;
			case 23:
				return Cuadro.ESQUINADER;
			case 24:
				return Cuadro.PAREDFLOR;
			case 25:
				return Cuadro.SUELOCUNA;
			case 26:
				return Cuadro.PENDIENTEDER;
			case 27:
				return Cuadro.PENDIENTEIZQ;
			case 28:
				return Cuadro.CIELO;
				
			default:
				return Cuadro.VACIO;
			
		}
	}
	
}
