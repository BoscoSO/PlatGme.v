package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public  abstract class Criatura extends Ente {
	protected Sprite sprite;
	protected char direccion='n';
	protected boolean enMovimiento=false;
	
	
	private int gravedad=2;
	
	
	public void actualizar() {
		
	}
	public void mostrar() {
		
	}
	public void mover(int desplazamientoX,int desplazamientoY) {
		if(desplazamientoX > 0) {
			direccion='e';
		}
		if(desplazamientoX < 0) {
			direccion='o';
		}
		if(desplazamientoY > 0) {
			direccion='s';
		}
		if(desplazamientoY < 0) {
			direccion='n';
		}
		
		
		
		if(!estaEliminado()) {
			if(!enColision(desplazamientoX,0)) {
				actualizarX(desplazamientoX);
			}
			
			if(!enColision(0,desplazamientoY)) {
				actualizarY(desplazamientoY);
			}
			
		}
	}

	
	private boolean enColision(int desplazamientoX, int desplazamientoY) {
		boolean colision=false;
		int posicionX= x+desplazamientoX;
		int posicionY= y+desplazamientoY;
		
		int margenIzquierdo= -14;	//Actualizar margenes personaje
		int margenDerecho= 23;
		
		int margenSuperior=-28;
		int margenInferior=32;
		
		int bordeIzquierdo = (posicionX+margenDerecho) / sprite.getLado();
		int bordeDerecho= (posicionX+margenDerecho+margenIzquierdo) / sprite.getLado();
		int bordeSuperior= (posicionY+margenInferior) / sprite.getLado();
		int bordeInferior= (posicionY+margenInferior+margenSuperior) / sprite.getLado();
		
		if(mapa.obtenerCuadroCatalogo(bordeIzquierdo+bordeSuperior*mapa.getAncho()).esSolido()) {
			colision=true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeIzquierdo+bordeInferior*mapa.getAncho()).esSolido()) {
			colision=true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeDerecho+bordeInferior*mapa.getAncho()).esSolido()) {
			colision=true;
		}
		if(mapa.obtenerCuadroCatalogo(bordeDerecho+bordeSuperior*mapa.getAncho()).esSolido()) {
			colision=true;
		}
		return colision;
	}
	public Sprite obtenSprite() {
		return this.sprite;
	}
}
