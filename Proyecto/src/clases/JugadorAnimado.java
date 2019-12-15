package clases;

import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends Tile{
private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	private int vida=3;
	
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y, indiceImagen, velocidad);
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	
		
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	
	public void mover(){
		/*if (Juego.derecha)
			this.x+=velocidad;*/
		
		/*if (Juego.izquierda)
		this.x-=velocidad;*/
		if(Juego.space)
			this.x+=velocidad;
		if (Juego.arriba)
			this.y-=velocidad;
		if (Juego.abajo)
			this.y+=velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion " + puntuacion, 0, 10);
		graficos.fillText("Vida "+vida,0 , 20);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					new Rectangle(12, 445, 48,40),
					new Rectangle(72,445, 48,40),
					new Rectangle(140,445, 48,40),
					new Rectangle(204,445, 48,40),
					new Rectangle(270,445, 48,40),
					new Rectangle(335,445, 48,40),
					new Rectangle(407,445, 48,40),
					new Rectangle(476,445, 48,40),

			};
			
			
			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.05);
			animaciones.put("correr",animacionCorrer);
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(0, 0, 40,35),
					new Rectangle(47,0, 40,35),
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
	
            Rectangle coordenadasSalto[]= {
            		new Rectangle(11,280,48,29),
            		new Rectangle(7,174,46,37),
            		new Rectangle(7,174,46,37),
            		new Rectangle(67,174,46,37),
            		new Rectangle(67,174,46,37),
            		new Rectangle(143,187,41,27),
            		
            };
            Animacion animacionSalto = new Animacion("salto",coordenadasSalto,0.2);
			animaciones.put("salto",animacionSalto);
	}
	
	public void verificarColisiones(Item items) {
		if (this.obtenerRectangulo().intersects(items.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!items.isCapturado())
					this.puntuacion++;
				items.setCapturado(true);				
		}
	}
	
	public void verificarColisionFatal(ColisionFatal choque) {
		if (this.obtenerRectangulo().intersects(choque.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!choque.isCapturado())
					this.vida--;
				choque.setCapturado(true);				
		}
	}
     
	public void detenerJuego() {
		
		while(this.vida==0)
			JOptionPane.showInputDialog( "HAS PERDIDO");
				
	}

}


