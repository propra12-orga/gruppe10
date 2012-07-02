import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

public class Move2 {
	Timer timer = new Timer();

	private static boolean up = true;
	private static boolean left = false, right = false, down = false;
	private static boolean win = false;

	public void keyboard(KeyEvent e) {
		int key = e.getKeyCode();

		if((key == KeyEvent.VK_A) && (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() - 1].laufen)) {
			if(left) {
				Blockeigenschaft.rasen(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
				Spielfeld.setSpalte2(Spielfeld.getSpalte2() - 1);
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].endpunkt) {
					win = true;
					Funktion.gewinner2();
				}
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].explosion) {
					win = true;
					Blockeigenschaft.explosion(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
					Funktion.gewinner1();
				}
				else Blockeigenschaft.spieler2(Spielfeld.getZeile2(), Spielfeld.getSpalte2(), "left");
			}

			else {
				left = true;
				right = false;
				up = false;
				down = false;
				Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].setIcon(new ImageIcon("images/Bomberwomanleft2.png"));
			}
		}

		else if((key == KeyEvent.VK_D) && (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() + 1].laufen)) {
			if(right) {
				Blockeigenschaft.rasen(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
				Spielfeld.setSpalte2(Spielfeld.getSpalte2() + 1);
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].endpunkt) {
					win = true;
					Funktion.gewinner2();
				}
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].explosion) {
					win = true;
					Blockeigenschaft.explosion(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
					Funktion.gewinner1();
				}
				else Blockeigenschaft.spieler2(Spielfeld.getZeile2(), Spielfeld.getSpalte2(), "right");
			}

			else {
				left = false;
				right = true;
				up = false;
				down = false;
				Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].setIcon(new ImageIcon("images/Bomberwomanright2.png"));
			}
		}

		else if((key == KeyEvent.VK_W) && (Spielfeld.feld[Spielfeld.getZeile2() - 1][Spielfeld.getSpalte2()].laufen)) {
			if(up) {
				Blockeigenschaft.rasen(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
				Spielfeld.setZeile2(Spielfeld.getZeile2() - 1);
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].endpunkt) {
					win = true;
					Funktion.gewinner2();
				}
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].explosion) {
					win = true;
					Blockeigenschaft.explosion(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
					Funktion.gewinner1();
				}
				else Blockeigenschaft.spieler2(Spielfeld.getZeile2(), Spielfeld.getSpalte2(), "up");
			}

			else {
				left = false;
				right = false;
				up = true;
				down = false;
				Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].setIcon(new ImageIcon("images/Bomberwomanback2.png"));
			}
		}

		else if((key == KeyEvent.VK_S) && (Spielfeld.feld[Spielfeld.getZeile2() + 1][Spielfeld.getSpalte2()].laufen)) {
			if(down) {
				Blockeigenschaft.rasen(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
				Spielfeld.setZeile2(Spielfeld.getZeile2() + 1);
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].endpunkt) {
					win = true;
					Funktion.gewinner2();
				}
				
				if(Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].explosion) {
					win = true;
					Blockeigenschaft.explosion(Spielfeld.getZeile2(), Spielfeld.getSpalte2());
					Funktion.gewinner1();
				}
				else Blockeigenschaft.spieler2(Spielfeld.getZeile2(), Spielfeld.getSpalte2(), "down");
			}

			else {
				left = false;
				right = false;
				up = false;
				down = true;
				Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2()].setIcon(new ImageIcon("images/Bomberwoman2.png"));
			}
		}

		else if(key == KeyEvent.VK_Y) {
			if((up) && (Spielfeld.feld[Spielfeld.getZeile2() - 1][Spielfeld.getSpalte2()].laufen)
					&& (Spielfeld.feld[Spielfeld.getZeile2() - 1][Spielfeld.getSpalte2()].endpunkt == false)) {
				Blockeigenschaft.bombe2(Spielfeld.getZeile2() - 1, Spielfeld.getSpalte2());
				timer.schedule(new BombeTask(3, Spielfeld.getZeile2() - 1, Spielfeld.getSpalte2()), 2800);
			}
			else if((down) && (Spielfeld.feld[Spielfeld.getZeile2() + 1][Spielfeld.getSpalte2()].laufen)
					&& (Spielfeld.feld[Spielfeld.getZeile2() + 1][Spielfeld.getSpalte2()].endpunkt == false)) {
				Blockeigenschaft.bombe2(Spielfeld.getZeile2() + 1, Spielfeld.getSpalte2());
				timer.schedule(new BombeTask(3, Spielfeld.getZeile2() + 1, Spielfeld.getSpalte2()), 2800);
			}
			else if((left) && (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() - 1].laufen)
					&& (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() - 1].endpunkt == false)) {
				Blockeigenschaft.bombe2(Spielfeld.getZeile2(), Spielfeld.getSpalte2() - 1);
				timer.schedule(new BombeTask(3, Spielfeld.getZeile2(), Spielfeld.getSpalte2() - 1), 2800);
			}
			else if((right) && (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() + 1].laufen)
					&& (Spielfeld.feld[Spielfeld.getZeile2()][Spielfeld.getSpalte2() + 1].endpunkt == false)) {
				Blockeigenschaft.bombe2(Spielfeld.getZeile2(), Spielfeld.getSpalte2() + 1);
				timer.schedule(new BombeTask(3, Spielfeld.getZeile2(), Spielfeld.getSpalte2() + 1), 2800);
			}
		}
		if((key == KeyEvent.VK_N) && (win)) {
			Spielfeld.setZeile(1);
			Spielfeld.setSpalte(1);
			Spielfeld.setZeile2(9);
			Spielfeld.setSpalte2(9);
			if (Menu.anzahlSpieler == 1) {
				Spielfeld.panel.removeAll();
	        	Spielfeld spielfeld = new Spielfeld();
	        	spielfeld.neuesSpielfeld(1, "level1.txt");
			}
			else {
				if (Menu.level1) {
					Spielfeld.panel.removeAll();
					Spielfeld spielfeld = new Spielfeld();
		        	spielfeld.neuesSpielfeld(2, "level1.txt");
				}
				else {
					Spielfeld.panel.removeAll();
					Spielfeld spielfeld = new Spielfeld();
		        	spielfeld.neuesSpielfeld(2, "freerun.txt");
				}
			}
		}
		else if ((key == KeyEvent.VK_E) && (win)) { // druecke E fuer Exit
			Spielfeld.panel.removeAll();
			Spielfeld.frame.dispose();
		}
	}
}
