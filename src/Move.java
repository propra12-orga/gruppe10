import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

public class Move {
	Timer timer = new Timer();

	private static boolean up = false, left = false, right = false; // deklarieren von privaten Variablen
	private static boolean down = true; // setzte down auf true, da die Bomberwoman in dieser Richtung startet

	public void keyboard(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_LEFT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].laufen)) { // Check ob das Feld links von Bomberwoman "begehbar" ist
			if(left) { // Check ob Bomberwoman sich schon nach links gedreht hat
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte); // setze Rasen auf das Feld, von dem Bomberwoman kommt
				Spielfeld.spalte--; // zaehle Spalte 1 runter
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1(); // Endpunktcheck
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion) { // Check ob auf dem Feld auf das Bomberwoman geht eine Explosion ist
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte); // setze eine Explosion auf das Feld, auf das Bomberwoman geht
					Funktion.gewinner2(); // fuehre Funktion "gewinner2" aus, da Spieler1 von der Explosion getroffen wurde
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "left"); // ansonsten bewege die Bomberwoman nach links
			}

			else {
				left = true; // setzte left auf true
				right = false;
				up = false;
				down = false;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanleft.png")); // Bomberwoman dreht sich nach links
			}
		}

		else if((key == KeyEvent.VK_RIGHT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].laufen)) {
			if(right) {
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte);
				Spielfeld.spalte++; // zaehle Spalte 1 hoch
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "right");
			}

			else {
				left = false;
				right = true;
				up = false;
				down = false;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanright.png"));
			}
		}

		else if((key == KeyEvent.VK_UP) && (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].laufen)) {
			if(up) {
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte);
				Spielfeld.zeile--;
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "up");
			}

			else {
				left = false;
				right = false;
				up = true;
				down = false;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanback.png"));
			}
		}
		
		else if((key == KeyEvent.VK_DOWN) && (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].laufen)) {
			if(down) {
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte);
				Spielfeld.zeile++;
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
				
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "down");
			}

			else {
				left = false;
				right = false;
				up = false;
				down = true;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwoman.png"));
			}
		}
		
		else if(key == 32) { // Leerzeichen
			if((up) && (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].laufen) // Check ob sich Bomberwoman nach oben gedreht hat,
					&& (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].endpunkt == false)) { // das naechste Feld "begehbar" ist und kein Endpunkt ist
				Blockeigenschaft.bombe1(Spielfeld.zeile - 1, Spielfeld.spalte); // fuege dem Feld die Eigenschaften "bombe1" hinzu
				timer.schedule(new BombeTask(3, Spielfeld.zeile - 1, Spielfeld.spalte), 2800); // starte den Timer zur Zuendung der Bombe
			}
			else if((down) && (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile + 1, Spielfeld.spalte);
				timer.schedule(new BombeTask(3, Spielfeld.zeile + 1, Spielfeld.spalte), 2800);
			}
			else if((left) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile, Spielfeld.spalte - 1);
				timer.schedule(new BombeTask(3, Spielfeld.zeile, Spielfeld.spalte - 1), 2800);
			}
			else if((right) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile, Spielfeld.spalte + 1);
				timer.schedule(new BombeTask(3, Spielfeld.zeile, Spielfeld.spalte + 1), 2800);
			}
		}
	}
}
