package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class Cuadro {
	public int x;
	public int y;
	public Sprite sprite;
	
	public static final int LADO=32;
	
	//coleccion de cuadros
	public static final Cuadro VACIO=new Cuadro(Sprite.VACIO);
	public static final Cuadro AGUA=new Cuadro(Sprite.AGUA);
	public static final Cuadro BORDEAGUADER=new Cuadro(Sprite.BORDEAGUADER);
	public static final Cuadro BORDEAGUAIZQ=new Cuadro(Sprite.BORDEAGUAIZQ);
	public static final Cuadro BOTTOM=new Cuadro(Sprite.BOTTOM);
	public static final Cuadro BOTTOMAGUA=new Cuadro(Sprite.BOTTOMAGUA);
	public static final Cuadro BOTTOMSOLO=new Cuadro(Sprite.BOTTOMSOLO);
	public static final Cuadro CUELLOSOLO=new Cuadro(Sprite.CUELLOSOLO);
	public static final Cuadro ESQUINADER=new Cuadro(Sprite.ESQUINADER);
	public static final Cuadro ESQUINAIZQ=new Cuadro(Sprite.ESQUINAIZQ);
	public static final Cuadro NUBEDER=new Cuadro(Sprite.NUBEDER);
	public static final Cuadro NUBEIZQ=new Cuadro(Sprite.NUBEIZQ);
	public static final Cuadro PARED=new Cuadro(Sprite.PARED);
	public static final Cuadro PAREDAGUADER=new Cuadro(Sprite.PAREDAGUADER);
	public static final Cuadro PAREDAGUAIZQ=new Cuadro(Sprite.PAREDAGUAIZQ);
	public static final Cuadro PAREDDER=new Cuadro(Sprite.PAREDDER);
	public static final Cuadro PAREDFLOR=new Cuadro(Sprite.PAREDFLOR);
	public static final Cuadro PAREDIZQ=new Cuadro(Sprite.PAREDIZQ);
	public static final Cuadro PENDIENTEDER=new Cuadro(Sprite.PENDIENTEDER);
	public static final Cuadro PENDIENTEIZQ=new Cuadro(Sprite.PENDIENTEIZQ);
	public static final Cuadro PLATAFORMA=new Cuadro(Sprite.PLATAFORMA);
	public static final Cuadro PLATAFORMADER=new Cuadro(Sprite.PLATAFORMADER);
	public static final Cuadro PLATAFORMAIZQ=new Cuadro(Sprite.PLATAFORMAIZQ);
	public static final Cuadro PLATAFORMASOLO=new Cuadro(Sprite.PLATAFORMASOLO);
	public static final Cuadro SUELO=new Cuadro(Sprite.SUELO);
	public static final Cuadro SUELOCUNA=new Cuadro(Sprite.SUELOCUNA);
	public static final Cuadro SUELODER=new Cuadro(Sprite.SUELODER);
	public static final Cuadro SUELOIZQ=new Cuadro(Sprite.SUELOIZQ);
	public static final Cuadro SUELOSOLO=new Cuadro(Sprite.SUELOSOLO);
	public static final Cuadro CIELO=new Cuadro(Sprite.CIELO);
	//fin coleccion
	public Cuadro(Sprite sprite) {
		this.sprite=sprite;
	}
	public void mostrar(int x,int y,Pantalla pantalla) {
		pantalla.mostrarCuadro(x<<5, y<<5, this);
	}
	public boolean solido() {
		return false;
	}
	
}
