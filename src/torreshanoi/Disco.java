package torreshanoi;

import java.awt.*;

/**
 * Un disco de las torres de Hanoi.
 * 
 * @author Maestros computaci�n II
 * @version Primavera 2003
 */
public class Disco {
	
	private int b, h;   /*base, altura del disco */

	/**
	 * Constructor
	 */
	public Disco(int b, int h) {
	
		this.b = b;
		this.h = h;
	}

	/**
	 * Dibujar el disco en las coordenadas proporcionadas
	 * @param g     espacio gr�fico
	 * @param x     posici�n del centro del disco
	 * @param y     posici�n de la base del disco
	 */
	public void dibuja(Graphics g, int x, int y) {
	
		g.setColor(Color.red);
		g.fillRoundRect(x-b/2,y-h, b, h,10,10);
		g.setColor(Color.black);
		g.drawRoundRect(x-b/2,y-h, b, h,10,10);        
	}
}
