package clases;

//import javafx.scene.Node;

public class ColisionFatal extends Item{

	public ColisionFatal(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super(x, y, anchoImagen, altoImagen, xImagen, yImagen, indiceImagen, velocidad);
		
	}

	public ColisionFatal(int tipoTile,int x, int y, String indiceImagen, int velocidad) {
		super(tipoTile,x,  y,  indiceImagen,  velocidad);
		
		this.x=x;
		this.y=y;
		this.indiceImagen=indiceImagen;
		this.velocidad=velocidad;
		
		switch(tipoTile) {
		
		case 1:  
			this.altoImagen=45;
			this.anchoImagen=45;
			
			
			//"cora "
		break;
		
		}
		
	
	}


	
	
	
	
}
