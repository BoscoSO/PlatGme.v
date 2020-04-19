package entes;

import mapa.Mapa;

public abstract class Ente {
	protected int x;
	protected int y;
	
	private boolean eliminado=false;
	
	protected Mapa mapa;
	
	public void actualizar() {
		
	}
	public void mostrar() {
		
	}
	
	public void eliminar() {
		eliminado=true;
	}
	
	public int posicionX() {
		return this.x;
	}
	public void actualizarX(int xx) {
		x+=xx;
	}
	public int posicionY() {
		return this.y;
	}
	public void actualizarY(int yy) {
		y+=yy;
	}
	public boolean estaEliminado() {
		return this.eliminado;
	}
}
