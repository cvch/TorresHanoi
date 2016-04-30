package torreshanoi;
import java.awt.*;
    
/**
 * Un poste de las torres de Hanoi.
 * 
 * @author Maestros computaci�n II
 * @version Primavera 2003
 */
public class Poste {

	private int n;
	private int x, y; //coordenadas poste
	private int ad, bd; //altura y base del disco m�s grande
	private int ab, ap; //anchos de la base y poste
	private Disco disco[]; //discos del poste
    
	/**
	 * Constructor 
	 * @param n     numero inicial de discos
	 * @param px    coordenada x del poste
	 */
	public Poste(int n, int px) {

		this.n = n;
		x = px;
		y = 500;
		ad = 20;
		bd = 140;
		ab = 150;
		ap = 10;
		disco = new Disco[10]; //espacio para 10 discos
		for (int i = 0; i < n; i++) {
			disco[i]= new Disco((int)(bd * (1 - 0.1 * i)), ad);
		}
	}
    
	/**
	 * Reasignar el n�mero total de discos
	 * @param n      nuevo n�mero de discos
	 */
	public void ponDiscos(int n) {

		this.n = n;
		disco = new Disco[10];
		for(int i= 0; i < n; i++) {
			disco[i]= new Disco((int)(bd * (1 - 0.1*i)), ad);
		}
	}
   
	/**
	 * Agregar un disco al poste
	 * @param d      Disco a agregar
	 */
	public void agregaDisco(Disco d) {

		disco[n] = d;
		n++;    
	}
   
	/**
	 * Eliminar un disco del poste
	 * Pre: n>=1;
	 * @return   el disco eliminado
	 */
	public Disco quitaDisco() {

		n--;
		Disco d = disco[n];
		disco[n] = null;
		return d; 
	}
   
	/**
	 * Dibujar el poste
	 * @param g      el ambiente gr�fico
	 */
	public void dibuja(Graphics g) {

		//borrar fondo
		g.setColor(Color.white);
		g.fillRect(x - ab / 2, 500 - 15 * ad, ab, 15 * ad);
		//dibujar base
		g.setColor(Color.black);
		g.fillRect(x - ab / 2, 500 - ad, ab, ad);
		//dibujar poste
		g.setColor(Color.yellow);
		g.fillRect(x - ap / 2, 500 - 15 * ad, ap, 14 * ad);        
		//dibujar discos
		for(int i = 0; i < n; i++) {
			disco[i].dibuja(g, x, 500 - ad - i * ad);
		}
   }
}
