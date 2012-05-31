import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class BomberManMove extends JPanel {
	
	public boolean up, down, left, right;
	
	public void endpunkt(KeyEvent e) {
		
		int key = e.getKeyCode();
		if ((key == KeyEvent.VK_LEFT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].laufen)) { // Check, ob das naechste Feld eine Wand ist
			left = true;
			System.out.println("links");
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/gras.png")); // Gras an die Stelle, von der Bomberwoman kommt
			Spielfeld.spalte--;
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanleft.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_RIGHT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].laufen)) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
			right = true;
			System.out.println("rechts");
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/gras.png"));
			Spielfeld.spalte++; // spalte wird um 1 erhöht
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanright.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_UP) && (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].laufen)) {
			up = true;
			System.out.println("hoch");
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/gras.png"));
			Spielfeld.zeile--; // zeile wird um 1 verringert
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanback.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else if ((key == KeyEvent.VK_DOWN) && (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].laufen)) {
			down = true;
			System.out.println("runter");
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/gras.png"));
			Spielfeld.zeile++;
			Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwoman.png"));
			
			if (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) { // Endpunktcheck
				System.out.println("Endpunkt");
			}
		}
		else {
			System.out.println("Wand oder falsche Taste");
		}	
	}
}