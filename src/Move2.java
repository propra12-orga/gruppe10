import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Move2 {
	
	boolean up, down, left, right;
	private KeyEvent e;
	
	public void keyboard(KeyEvent e) {
		
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_A) && (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2 - 1].laufen)) { // Check, ob das naechste Feld eine Wand ist
			left = true;
			System.out.println("links");
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/rasen.png")); // Gras an die Stelle, von der Bomberwoman kommt
			Spielfeld.spalte2--;
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/Bomberwomanleft2.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_D) && (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2 + 1].laufen)) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
			right = true;
			System.out.println("rechts");
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/rasen.png"));
			Spielfeld.spalte2++; // spalte wird um 1 erhöht
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/Bomberwomanright2.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_W) && (Spielfeld.feld[Spielfeld.zeile2 - 1][Spielfeld.spalte2].laufen)) {
			up = true;
			System.out.println("hoch");
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/rasen.png"));
			Spielfeld.zeile2--; // zeile wird um 1 verringert
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/Bomberwomanback2.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_S) && (Spielfeld.feld[Spielfeld.zeile2 + 1][Spielfeld.spalte2].laufen)) {
			down = true;
			System.out.println("runter");
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/rasen.png"));
			Spielfeld.zeile2++;
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/Bomberwoman2.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_Y)) {
			System.out.println("Bombe");
			Spielfeld.feld[Spielfeld.zeile2][Spielfeld.spalte2].setIcon(new ImageIcon("images/PropraBombe.png"));
		}
		
		else {
			System.out.println("Wand oder falsche Taste");}
		}	

	
	}
