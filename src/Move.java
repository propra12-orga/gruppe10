import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

public class Move {
	Timer timer = new Timer();

	private static boolean up = false;
	private static boolean left = false;
	private static boolean right = false;
	private static boolean down = true;

	public void keyboard(KeyEvent e) {
		int key = e.getKeyCode();
		
		if((key == KeyEvent.VK_LEFT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].laufen)) {
			if(left) {
				
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte);
				Spielfeld.spalte--;
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion == true) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "left");

				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
			}

			else {
				left = true;
				right = false;
				up = false;
				down = false;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwomanleft.png")); // dreht // sich
			}
		}

		else if((key == KeyEvent.VK_RIGHT) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].laufen)) {
			if(right) {
				Blockeigenschaft.rasen(Spielfeld.zeile, Spielfeld.spalte);
				Spielfeld.spalte++;
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion == true) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "right");

				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
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
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion == true) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "up");

				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
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
				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].explosion == true) { 
					Blockeigenschaft.explosion(Spielfeld.zeile, Spielfeld.spalte);
					Funktion.gewinner2();
				}
				else Blockeigenschaft.spieler1(Spielfeld.zeile, Spielfeld.spalte, "down");

				if(Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].endpunkt) Funktion.gewinner1();
			}

			else {
				left = false;
				right = false;
				up = false;
				down = true;
				Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte].setIcon(new ImageIcon("images/Bomberwoman.png"));
			}
		}
		
		else if(key == 32) {
			if((up) && (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile - 1][Spielfeld.spalte].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile - 1, Spielfeld.spalte);
				timer.schedule(new BombeTask(3, Spielfeld.zeile - 1, Spielfeld.spalte), 2000);
			}
			else if((down) && (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile + 1][Spielfeld.spalte].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile + 1, Spielfeld.spalte);
				timer.schedule(new BombeTask(3, Spielfeld.zeile + 1, Spielfeld.spalte), 2000);
			}
			else if((left) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte - 1].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile, Spielfeld.spalte - 1);
				timer.schedule(new BombeTask(3, Spielfeld.zeile, Spielfeld.spalte - 1), 2000);
			}
			else if((right) && (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].laufen)
					&& (Spielfeld.feld[Spielfeld.zeile][Spielfeld.spalte + 1].endpunkt == false)) {
				Blockeigenschaft.bombe1(Spielfeld.zeile, Spielfeld.spalte + 1);
				timer.schedule(new BombeTask(3, Spielfeld.zeile, Spielfeld.spalte + 1), 2000);
			}
		}
	}
}
