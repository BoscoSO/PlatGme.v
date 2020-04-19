package graficos;

public final class Sprite {
	private final int lado;
	
	private int x;
	private int y;
	
	public int[] pixeles;
	private HojaSprites hoja;
	//coleccion de sprites del personaje
	public static final Sprite jugadorFrente=new Sprite(32,0,0,0,HojaSprites.jugador);
	//movimiento derecha
	public static final Sprite derecha0=new Sprite(32,0,1,0,HojaSprites.jugador);
	public static final Sprite derecha1=new Sprite(32,1,1,0,HojaSprites.jugador);
	public static final Sprite derecha2=new Sprite(32,2,1,0,HojaSprites.jugador);
	public static final Sprite derecha3=new Sprite(32,3,1,0,HojaSprites.jugador);
	public static final Sprite derecha4=new Sprite(32,4,1,0,HojaSprites.jugador);
	public static final Sprite derecha5=new Sprite(32,5,1,0,HojaSprites.jugador);
	public static final Sprite derecha6=new Sprite(32,6,1,0,HojaSprites.jugador);
	public static final Sprite derecha7=new Sprite(32,7,1,0,HojaSprites.jugador);
	//movimiento izquierda
	public static final Sprite izquierda0=new Sprite(32,0,1,1,HojaSprites.jugador);
	public static final Sprite izquierda1=new Sprite(32,1,1,1,HojaSprites.jugador);
	public static final Sprite izquierda2=new Sprite(32,2,1,1,HojaSprites.jugador);
	public static final Sprite izquierda3=new Sprite(32,3,1,1,HojaSprites.jugador);
	public static final Sprite izquierda4=new Sprite(32,4,1,1,HojaSprites.jugador);
	public static final Sprite izquierda5=new Sprite(32,5,1,1,HojaSprites.jugador);
	public static final Sprite izquierda6=new Sprite(32,6,1,1,HojaSprites.jugador);
	public static final Sprite izquierda7=new Sprite(32,7,1,1,HojaSprites.jugador);
	//coleccion de sprites de mapa
	public static final Sprite VACIO=new Sprite(32,0);
	public static final Sprite CIELO=new Sprite(32, 5, 0,0,HojaSprites.hojaSprites);
	
	public static final Sprite SUELOSOLO=new Sprite(32, 0, 0,0, HojaSprites.hojaSprites);
	public static final Sprite CUELLOSOLO=new Sprite(32, 0, 1,0, HojaSprites.hojaSprites);
	public static final Sprite BOTTOMSOLO=new Sprite(32, 0, 2,0, HojaSprites.hojaSprites);
	
	
	///////////////
	public static final Sprite SUELOIZQ=new Sprite(32, 1, 0,0, HojaSprites.hojaSprites);
	public static final Sprite SUELO=new Sprite(32, 2, 0,0, HojaSprites.hojaSprites);
	public static final Sprite SUELODER=new Sprite(32, 1, 0,1, HojaSprites.hojaSprites);
	
	public static final Sprite PAREDIZQ=new Sprite(32, 1, 1,0, HojaSprites.hojaSprites);
	public static final Sprite PARED=new Sprite(32, 2, 1,0, HojaSprites.hojaSprites);
	public static final Sprite PAREDDER=new Sprite(32, 1, 1,1, HojaSprites.hojaSprites);

	public static final Sprite ESQUINAIZQ=new Sprite(32, 1, 2,0, HojaSprites.hojaSprites);
	public static final Sprite BOTTOM=new Sprite(32, 2, 2,0, HojaSprites.hojaSprites);
	public static final Sprite ESQUINADER=new Sprite(32, 1, 2,1, HojaSprites.hojaSprites);
	///////////////
	public static final Sprite PLATAFORMAIZQ=new Sprite(32, 3, 0,0, HojaSprites.hojaSprites);
	public static final Sprite PLATAFORMA=new Sprite(32, 3, 1,0, HojaSprites.hojaSprites);
	public static final Sprite PLATAFORMADER=new Sprite(32, 3, 0,1, HojaSprites.hojaSprites);
	
	public static final Sprite PLATAFORMASOLO=new Sprite(32, 3,2,0, HojaSprites.hojaSprites);
	
	public static final Sprite NUBEIZQ=new Sprite(32, 4, 1,0, HojaSprites.hojaSprites);
	public static final Sprite NUBEDER=new Sprite(32, 5, 1,0, HojaSprites.hojaSprites);
	
	public static final Sprite PAREDFLOR=new Sprite(32, 4, 2,0, HojaSprites.hojaSprites);
	public static final Sprite SUELOCUNA=new Sprite(32, 5, 2,0, HojaSprites.hojaSprites);
	public static final Sprite PENDIENTEDER=new Sprite(32, 4, 0,0, HojaSprites.hojaSprites);
	public static final Sprite PENDIENTEIZQ=new Sprite(32, 4, 0,1, HojaSprites.hojaSprites);
	
	public static final Sprite BORDEAGUAIZQ=new Sprite(32, 6, 0,0, HojaSprites.hojaSprites);
	public static final Sprite AGUA=new Sprite(32, 7, 0,0, HojaSprites.hojaSprites);
	public static final Sprite BORDEAGUADER=new Sprite(32, 6, 0,1, HojaSprites.hojaSprites);
	
	public static final Sprite PAREDAGUAIZQ=new Sprite(32, 6, 1,0, HojaSprites.hojaSprites);
	public static final Sprite BOTTOMAGUA=new Sprite(32, 7, 1,0, HojaSprites.hojaSprites);
	public static final Sprite PAREDAGUADER=new Sprite(32, 6, 1,1, HojaSprites.hojaSprites);
	//fin de la coleccion
	public Sprite(final int lado, final int color) {
		this.lado=lado;
		pixeles=new int[lado*lado];
		for (int i=0;i<pixeles.length;i++) {
			pixeles[i]=color;
		}
		
	}
	public Sprite(final int lado,final int columna, final int fila,int version, final HojaSprites hoja) {
		this.lado=lado;
		
		pixeles=new int[lado * lado];
		
		this.x = columna* lado;
		this.y = fila* lado;
		this.hoja=hoja;
		cargarSprite(version);
		
		
	}
	public int getLado() {
		return lado;
	}
	
	private void cargarSprite(int version) {
		if(version==0) {
			cargaNormal();
		}else {
			cargaManipulada(version);
		}
	}
	
	private void cargaNormal() {
		for(int y=0;y<lado;y++) {
			for(int x=0;x<lado;x++) {
				pixeles[x + y * lado]=hoja.pixeles[(x+ this.x) + (y+this.y)* hoja.getAncho()];
				
			}
		}
	}
	private int[] iniciarPixTemp() {
		int[] pixelesTemporales=new int[lado*lado];
		
		for(int y=0;y<lado;y++) {
			for(int x=0;x<lado;x++) {
				pixelesTemporales[x + y * lado]=hoja.pixeles[(x+ this.x) + (y+this.y)* hoja.getAncho()];
				
			}
		}
		return pixelesTemporales;
	}
	
	private void cargaManipulada(int version) {
		int[] pixelesTemporales=iniciarPixTemp();
		switch(version) {
			case 1: 
				invertirX(pixelesTemporales);
				break;
			case 2:
				invertirY(pixelesTemporales);
				break;
			case 3:
				invertirXY(pixelesTemporales);
				break;
			case 4:
				rotar90Izq(pixelesTemporales);
				break;
			case 5:
				rotar90Der(pixelesTemporales);
				break;
			case 6:
				rotarI90InvertirY(pixelesTemporales);
				break;
			case 7:
				rotarD90InvertirY(pixelesTemporales);
				break;
			default:
				cargaNormal();
		}
	}
	
	
	//1
	private void invertirX(int[] pixelesTemporales) {
		int i=0;
		for(int y=0;y<lado;y++){
			for(int x=lado-1;x>-1;x--){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
	//2
	private void invertirY(int[] pixelesTemporales) {
		int i=0;
		for(int y=lado-1;y>-1;y--){	
			for(int x=0;x<lado;x++){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
	//3
	private void invertirXY(int[] pixelesTemporales) {
		for(int i=0;i<pixeles.length;i++){
			pixeles[i]=pixelesTemporales[pixelesTemporales.length-1-i];
			i++;
		}
	}
	//4
	private void rotar90Izq(int[] pixelesTemporales) {
		int i=0;
		for(int x=lado-1;x>-1;x--){
			for(int y=0;y<lado;y++){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
	//5
	private void rotar90Der(int[] pixelesTemporales) {
		int i=0;
		for(int x=0;x<lado;x++){
			for(int y=lado-1;y>-1;y--){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
	//6
	private void rotarI90InvertirY(int[] pixelesTemporales) {
		int i=0;
		for(int x=0;x<lado;x++){
			for(int y=0;y<lado;y++){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
	//7
	private void rotarD90InvertirY(int[] pixelesTemporales) {
		int i=0;
		for(int x=lado-1;x>-1;x--){
			for(int y=lado-1;y>-1;y--){
				pixeles[i]=pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
}
