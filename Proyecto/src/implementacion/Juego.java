package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.ColisionFatal;
import clases.Item;
import clases.Jugador;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	private int vida=100;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	private Item item;
	private Item item2;
	private Item item3;
	private ColisionFatal choque;
	
	//private ArrayList<Image> imagenes;
	
	private ArrayList<Tile> tiles;
	
	private int[][] mapa = {
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			{8,8,3,9,3,3,2,1,9,1},
			

	};
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("el enculado");
		gestionarEventos();
		ventana.show();
		//boolean jugando=false;
		cicloJuego();		
		
		
	}
	
	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(0,304,"KIRBY",1, "correr");
		root = new Group();
		escena = new Scene(root,1000,338);
		canvas  = new Canvas(1000,338);
		imagenes = new HashMap<String,Image>();
		item = new Item(600,275,0,0,"cora ");
		item2 = new Item(400,275,0,0,"cora ");
		item3=new Item(500,275,0,0, "cora ");
		choque=new ColisionFatal(300,260,0,0,"donald");
		cargarImagenes();
		cargarTiles();
	}
	
	public void cargarImagenes() {
		/*imagenes.put("goku", new Image("goku.png"));
		imagenes.put("goku-furioso", new Image("goku-furioso.png"));*/
		imagenes.put("mapa", new Image("mapa.png"));
		imagenes.put("KIRBY", new Image("KIRBY.png"));
		imagenes.put("cora ", new Image("cora .png"));
		imagenes.put("donald", new Image("donald.png"));
	}
	
	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 1000, 338);
		graficos.setFill(Color.BLACK);
	
		///Pintar tiles
		for (int i=0;i<tiles.size();i++) 
			tiles.get(i).pintar(graficos);
			

		//graficos.fillText("Puntuacion: " + puntuacion, 10, 10);
		//graficos.fillText("Vida: " + vida, 20, 20);
		jugadorAnimado.pintar(graficos);	
		//jugador.pintar(graficos);
		item.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		choque.pintar(graficos);

	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*34, j*34, "mapa",0));
			}
		}
	}
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							//jugadorAnimado.setVelocidad(3);
							//jugadorAnimado.setIndiceImagen("correr");
						break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						case "UP":
							arriba=true;
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							//jugador.setVelocidad(10);
							//jugador.setIndiceImagen("goku-furioso");
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					//jugadorAnimado.setVelocidad(1);
					//jugadorAnimado.setIndiceImagen("descanso");
					System.out.println("esperando");
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					//jugador.setVelocidad(1);
					//jugador.setIndiceImagen("goku");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		
		//boolean jugando=false;
		//while(vida!=0) {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				//cargarTiles();
			}
		
		};
		animationTimer.start(); //Inicia el ciclo
		//}//cargarTiles();
	}
	
	public void actualizar(double t) {
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		//cargarTiles();
		jugadorAnimado.verificarColisiones(item);
		jugadorAnimado.verificarColisiones(item2);
		jugadorAnimado.verificarColisiones(item3);
	   //jugadorAnimado.inicializarAnimaciones();
	   jugadorAnimado.verificarColisionFatal(choque);
	}

}
