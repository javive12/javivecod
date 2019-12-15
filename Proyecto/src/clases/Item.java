package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item extends Tile {
	/*private int x;
	private int y;
	private int ancho;
	private int alto;
	private String indiceImagen;*/
	private boolean capturado;
	
	
	
	public Item(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super(x, y, anchoImagen, altoImagen, xImagen, yImagen, indiceImagen, velocidad);
	}

	public Item(int tipoTile,int x, int y, String indiceImagen, int velocidad) {
		super(tipoTile,x,  y,  indiceImagen,  velocidad);
		
		this.x=x;
		this.y=y;
		this.indiceImagen=indiceImagen;
		this.velocidad=velocidad;
		
		switch(tipoTile) {
		
		case 1:  
			this.altoImagen=25;
			this.anchoImagen=23;
			
			
			//"cora "
		break;
		
		}
		
	
	}
	


	public void pintar(GraphicsContext graficos) {
		
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), this.x--, this.y);
		//graficos.fillRect(this.x, this.y, 18, 18);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 10, 10);
	}

	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	
	
}
