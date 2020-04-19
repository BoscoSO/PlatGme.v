package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import control.Teclado;
import entes.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.MapaGenerado;

public class Juego extends Canvas implements Runnable  {
// https://www.youtube.com/watch?v=QTTiNeDKvS4  EP-25
	private static final long serialVersionUID = 1L;
	private static final int ANCHO=700;
	private static final int ALTO=400; 
	private static final String NOMBRE="Juego";

	private static String CONTADOR_APS="";
	private static String CONTADOR_FPS="";
	
	private static int aps=0;
	private static int fps=0;
	
	
	private static volatile boolean encendido=false;
	
	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	
	private static Mapa mapa;
	private static Jugador jugador;
	
	private static BufferedImage imagen=new BufferedImage(ANCHO,ALTO,
			BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt)imagen.getRaster()
			.getDataBuffer()).getData();
	
	
	private Juego() {
		setPreferredSize(new Dimension(ANCHO,ALTO));
		pantalla= new Pantalla(ANCHO,ALTO);
		
		//mapa=new MapaGenerado(128,128);
		mapa=new MapaCargado("/mapas/mapa.png");

		teclado= new Teclado();
		jugador=new Jugador(teclado,Sprite.jugadorFrente,271,286);
		
		addKeyListener(teclado);
		
		ventana= new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
	
	}
	
	
	
	public static void main(String[] args) {
		Juego juego=new Juego();
		juego.iniciar();
	}
	private synchronized void iniciar() {
		encendido=true;
		thread=new Thread(this, "Graficos");
		thread.start();
	}
	private synchronized void detener() {
		encendido=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void actualizar() {
		teclado.actualizar();
		jugador.actualizar();
		
		if(teclado.salir) {
			System.exit(0);
		}
		
		
		aps++;
	}
	private void mostrar() {
		BufferStrategy estrategia= getBufferStrategy(); 
		
		if(estrategia==null) {
			createBufferStrategy(3);
			return;
		}
		
		pantalla.limpiar();
		
		mapa.mostrar(jugador.posicionX()-pantalla.getAncho()/2+jugador.obtenSprite().getLado()/2,
				jugador.posicionY()-pantalla.getAlto()/2+jugador.obtenSprite().getLado()/2, pantalla);
		jugador.mostrar(pantalla);	
		
		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
		
		
		Graphics g=estrategia.getDrawGraphics();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.red);

		g.drawString(CONTADOR_APS,10,20 );
		g.drawString(CONTADOR_FPS,10,35 );
		g.drawString("X: "+jugador.posicionX(), 10, 50);
		g.drawString("Y: "+jugador.posicionY(), 10, 65);
		g.dispose();
		
		estrategia.show();
		
		fps++;
	}


	public void run() {
		final int NS_POR_SEGUNDO=1000000000;
		final byte APS_OBJETIVO=120;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion=System.nanoTime();
		long referenciaContador=System.nanoTime();
		double tiempoTranscurrido;
		double delta=0;
		
		requestFocus();//se centra en la pantalla
		
		while(encendido) {
			final long inicioBucle =System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			while(delta>=1) {
				actualizar();
				delta--;	
			}
			mostrar();
			
			if(System.nanoTime()-referenciaContador > NS_POR_SEGUNDO) {
				//ventana.setTitle(NOMBRE + " || APS: "+aps+" || FPS: "+fps);
				CONTADOR_APS= " || APS: "+aps;
				CONTADOR_FPS= " || FPS: "+fps;
				
				aps=0;
				fps=0;
				referenciaContador=System.nanoTime();
			}
			
		}
	}

}
