package clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends Tile{
private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	protected int puntuacion = 0;
	public static int vida=1;
	protected int salir=0;
	protected String deci="";
	//private Juego jugando;
	public JugadorAnimado(int x, int y, String indiceImagen, int velocidad, String animacionActual) {
		super(x, y, indiceImagen, velocidad);
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}
	
	public JugadorAnimado(int puntuacion, int vida) {
		super();
	    //this.vida=vida;
		this.puntuacion=puntuacion;
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
		if(Juego.space)
			this.x+=(velocidad);
		else
         this.x-=1;
		if (Juego.arriba)
			this.y-=velocidad;
		if (Juego.abajo)
			this.y+=velocidad;
//         this.x-=velocidad;  
         if(this.x<=10)
        	 this.x=25;
		if(this.y>=375)
        	   this.y=360;
           if(this.y<=15)
        	   this.y=20;
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
				if (!items.isCapturado())
					this.puntuacion++;
				items.setCapturado(true);				
		}
	}
	
	public void verificarColisionFatal(ColisionFatal choque) {
		if (this.obtenerRectangulo().intersects(choque.obtenerRectangulo().getBoundsInLocal())) {
				if (!choque.isCapturado())
					JugadorAnimado.vida--;
				choque.setCapturado(true);				
		}
	}



	protected static int getVida() {
		return vida;
	}

	protected static void setVida(int vida) {
		JugadorAnimado.vida = vida;
}

	
	public void guardarPuntuacio() {
		String puntos="";
		puntos+=JugadorAnimado.vida;
		
		try {
		BufferedWriter flujo = new BufferedWriter(new FileWriter("puntuacio.csv",true));
		flujo.write( "");
		flujo.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	@Override
	public String toString() {
		return "JugadorAnimado [puntuacion=" + puntuacion + "]";
	}

	public void toScv() {
		String puntos="";
		puntos="JugadorAnimado [puntuacion=" + puntuacion + "]"		;
	}
}





