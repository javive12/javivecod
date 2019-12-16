package implementacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.ColisionFatal;
import clases.Item;
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
	private JugadorAnimado jugadorAnimado;
//	private JugadorAnimado jugadorAnimado2;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean space=false;
	protected int jugando=0;
	protected int vamos;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	public static  boolean deci=false;
	//private Tile ahora;
	private ArrayList<Tile> tiles;
	private ArrayList<Item> item;
	private ArrayList<ColisionFatal> choque;
	//private ArrayList<JugadorAnimado> animacion;
	//private Stage ventana;
	private int[][] mapa = {
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
			{3,3,3,2,1,1,9,1,1,9,1,1},
						

									

	};
		private int[][] items= {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					
			
	};
	private int[][] donald= {
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,1,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,0,0,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,1,0,0,1,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,0,0,0,1,0,1,0},
			
	};
	
	
	
	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage ventana) throws Exception {
		Iniciar();
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("Rum kirb");
		gestionarEventos();
		ventana.show();
		cicloJuego();
		}
		
	
	public void inicializarComponentes() {
		jugadorAnimado = new JugadorAnimado(0,250,"KIRBY",3, "correr");
		root = new Group();
		escena = new Scene(root,1000,400);
		canvas  = new Canvas(1000,400);
		imagenes = new HashMap<String,Image>();
		cargarImagenes();
		cargarTiles();
		cargarItems();
		cargarDonald();
	}
	
	public void cargarImagenes() {
		imagenes.put("mapa", new Image("mapa.png"));
		imagenes.put("KIRBY", new Image("KIRBY.png"));
		imagenes.put("cora ", new Image("cora .png"));
		imagenes.put("donald", new Image("donald.png"));
	}
	
	public void pintar() {
      
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 1000, 400);
		graficos.setFill(Color.BLACK);
	
		///Pintar tiles
		for (int i=0;i<tiles.size();i++) {
		tiles.get(i).pintar(graficos);
		tiles.get(i).moverTiles();
		}//pintar items
		for(int i=0;i<item.size();i++) {
			item.get(i).pintar(graficos);
			item.get(i).moverItems();
	}//pintar villano
		for(int i = 0; i<choque.size();i++) {
		choque.get(i).pintar(graficos);
		choque.get(i).moverDonalds();
	}
		jugadorAnimado.pintar(graficos);	
		
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
	
	public void cargarItems() {
		item= new ArrayList<Item>();
		
		
		for(int i =0;i<items.length;i++)
			for(int j=0; j<items[i].length;j++) {
				if(items[i][j]!=0)
			 item.add(new Item(items[i][j], i*25, j*23, "cora ",0));				
			}			
	}

	public void colisionarItems() {
		for(int i=0; i<item.size();i++)
			jugadorAnimado.verificarColisiones(item.get(i));
            		
	}
	public void cargarDonald() {
	choque = new ArrayList<ColisionFatal> ();
	 
	for(int i =0;i<donald.length;i++)
		for(int j=0; j<donald[i].length;j++) {
			if(donald[i][j]!=0)
				choque.add(new ColisionFatal(donald[i][j], i*45, j*45, "donald",0));
			}
	
		
	}
	
	public void colisionarDonalds() {
		for(int i=0; i<choque.size();i++)
			jugadorAnimado.verificarColisionFatal(choque.get(i));
		
	}
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "UP":
							arriba=true;
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							space=true;
							break;
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					space=false;
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		
 	long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
			}
		
		};
		animationTimer.start(); //Inicia el ciclo
	  
	}
	
	public void actualizar(double t) {
		
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
	   colisionarItems();
	   colisionarDonalds();
		 detener();
			
	}
	
	public void Iniciar() {
		
		this.jugando=Integer.parseInt(JOptionPane.showInputDialog(" Presione 1 para Iniciar "));
		if(jugando!=1) { 
			this.jugando=Integer.parseInt(JOptionPane.showInputDialog(" Presione 1 para Iniciar "));
			JugadorAnimado.vida+=1;
			   }
		
	}

	public void detener() {
               if(JugadorAnimado.vida==0)
		JOptionPane.showMessageDialog(null,"perdiste \n "+ "Adios");	

	
 }

	
	}
      

	
