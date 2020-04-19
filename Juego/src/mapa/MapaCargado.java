package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.cuadro.Cuadro;

public class MapaCargado extends Mapa {

	private int[] pixeles;
	
	public MapaCargado(String ruta) {
		super(ruta);
		
	}
	
	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
			
			ancho=imagen.getWidth();
			alto=imagen.getHeight();
			
			cuadrosCatalogo=new Cuadro[ancho*alto];
			pixeles=new int[ancho*alto];
			
			imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	protected void generarMapa() {
		
		for(int i=0;i<pixeles.length;i++) {
			switch(pixeles[i]) {
				case 0xff1ef31c:
					cuadrosCatalogo[i]=Cuadro.SUELOSOLO;
					continue;
				case 0xff00851c:
					cuadrosCatalogo[i]=Cuadro.SUELOIZQ;
					continue;
				case 0xff803020:
					cuadrosCatalogo[i]=Cuadro.PARED;
					continue;
				case 0xff641a0b:
					cuadrosCatalogo[i]=Cuadro.CUELLOSOLO;
					continue;
				case 0xff380a11:
					cuadrosCatalogo[i]=Cuadro.BOTTOMSOLO;
					continue;
				case 0xff47bc5f :
					cuadrosCatalogo[i]=Cuadro.SUELO;
					continue;
				case 0xff38fe61:
					cuadrosCatalogo[i]=Cuadro.SUELODER;
					continue;
				case 0xffad1ba8:
					cuadrosCatalogo[i]=Cuadro.PAREDIZQ;
					continue;
				case 0xffca44c5:
					cuadrosCatalogo[i]=Cuadro.PAREDDER;
					continue;
				case 0xffcb2271:
					cuadrosCatalogo[i]=Cuadro.ESQUINAIZQ;
					continue;
				case 0xffde6da2:
					cuadrosCatalogo[i]=Cuadro.ESQUINADER;
					continue;
				case 0xffff0077:
					cuadrosCatalogo[i]=Cuadro.BOTTOM;
					continue;
				case 0xff07773a:
					cuadrosCatalogo[i]=Cuadro.SUELOCUNA;
					continue;
				case 0xffdae74f:
					cuadrosCatalogo[i]=Cuadro.PENDIENTEDER;
					continue;
				case 0xffb6c519:
					cuadrosCatalogo[i]=Cuadro.PENDIENTEIZQ;
					continue;
				case 0xfffbc468:
					cuadrosCatalogo[i]=Cuadro.PLATAFORMASOLO;
					continue;
				case 0xffbc914c :
					cuadrosCatalogo[i]=Cuadro.PLATAFORMA;
					continue;
				case 0xffd98700:
					cuadrosCatalogo[i]=Cuadro.PLATAFORMAIZQ;
					continue;
				case 0xffff9f00:
					cuadrosCatalogo[i]=Cuadro.PLATAFORMADER;
					continue;
				case 0xff5265fa:
					cuadrosCatalogo[i]=Cuadro.BORDEAGUAIZQ;
					continue;
				case 0xff1428c9:
					cuadrosCatalogo[i]=Cuadro.AGUA;
					continue;
				case 0xff6370d9:
					cuadrosCatalogo[i]=Cuadro.BORDEAGUADER;
					continue;
				case 0xff404885:
					cuadrosCatalogo[i]=Cuadro.PAREDAGUAIZQ;
					continue;
				case 0xff2a2f57:
					cuadrosCatalogo[i]=Cuadro.BOTTOMAGUA;
					continue;
				case 0xff545877:
					cuadrosCatalogo[i]=Cuadro.PAREDAGUADER;
					continue;
				case 0xffff0000:
					cuadrosCatalogo[i]=Cuadro.PAREDFLOR;
					continue;
				case 0xfffffe00:
					cuadrosCatalogo[i]=Cuadro.NUBEIZQ;
					continue;
				case 0xfffffe65:
					cuadrosCatalogo[i]=Cuadro.NUBEDER;
					continue;
				case 0xff74e8f7:
					cuadrosCatalogo[i]=Cuadro.CIELO;
					continue;
				default:
					cuadrosCatalogo[i]=Cuadro.VACIO;
					continue;
					
					
			}
		}
	}
	

}
