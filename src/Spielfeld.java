import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spielfeld implements KeyListener { // Implementierung vom Keylistener
	static int zeile = 1, spalte = 1, zeile2 = 9, spalte2 = 9; // deklarieren der Startposition der Bomberwomen
	static JFrame frame = new JFrame(); // erstellen eines neuen JFrame mit dem Namen "frame"
	static JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); // erstellen eines neuen JPanel mit dem Namen "panel" (besitzt ein 11 mal 11 Gridlayout)
	public static Feld[][] feld = new Feld[11][11]; // erstellen eines neuen 11 mal 11 Feld Arrays mit dem Namen "feld" (Feld Array = JLabel Array)
	
	public Spielfeld() {
		for(int x = 0; x < 11; x++) { // 2-dimensionale for-Schleife zur Erstellung des Spielfeldes
			for(int y = 0; y < 11; y++) {
				if(x == 0 || x == 10 || y == 0 || y == 10 || (x % 2 == 0 && y % 2 == 0)) { // Koordinaten fuer die nicht zerstoerbaren Waende
					Spielfeld.feld[x][y] = new Feld(new ImageIcon("images/wand2.png")); // setzte eine Wand and die Stelle x, y
					Blockeigenschaft.wand(x, y); // weise der Wand diese Eigenschaften zu (siehe Klasse Blockeigenschaften -> wand)
					panel.add(feld[x][y]); // Füge das fertige JLabel in das JPanel ein (feld -> panel)

				}
				else if((x == 3 && y == 2) || (x == 2 && y == 5) || (x == 2 && y == 7) || (x == 2 && y == 3) || (x == 3 && y == 3) || (x == 3 && y == 4)
						|| (x == 3 && y == 5) || (x == 3 && y == 6) || (x == 3 && y == 7) || (x == 3 && y == 8) || (x == 4 && y == 3) || (x == 4 && y == 5)
						|| (x == 4 && y == 7) || (x == 5 && y == 2) || (x == 5 && y == 3) || (x == 5 && y == 4) || (x == 5 && y == 6) || (x == 5 && y == 7)
						|| (x == 5 && y == 8) || (x == 6 && y == 3) || (x == 6 && y == 5) || (x == 6 && y == 7) || (x == 7 && y == 2) || (x == 7 && y == 3)
						|| (x == 7 && y == 4) || (x == 7 && y == 5) || (x == 7 && y == 6) || (x == 7 && y == 7) || (x == 7 && y == 8) || (x == 8 && y == 3)
						|| (x == 8 && y == 5) || (x == 8 && y == 7) || (x == 6 && y == 3)) { // Koordinaten für die zerstoerbaren Waende
					feld[x][y] = new Feld(new ImageIcon("images/wandbreak.png"));
					Blockeigenschaft.broecklig(x, y);
					panel.add(feld[x][y]);
				}
				else { // ansonsten setzte Rasen
					feld[x][y] = new Feld(new ImageIcon("images/rasen.png"));
					Blockeigenschaft.rasen(x, y);
					panel.add(feld[x][y]);
				}
			}
		}
		Blockeigenschaft.spieler1(zeile, spalte, "down"); // Startposition von Spieler 1 & zuweisen von Eigenschaften
		Blockeigenschaft.spieler2(zeile2, spalte2, "up"); // Startposition von Spieler 2 & zuweisen von Eigenschaften
		Blockeigenschaft.endpunkt(5, 5); // setzte den Endpunkt in die Mitte (5, 5)

		frame.add(panel); // fuege das JPanel in das JFrame (panel -> frame)
		frame.setTitle("BOMBERWOMAN"); // setzte Fenstertitel
		frame.setSize(550, 550); // setzte Fenstergroesse
		frame.setLocationRelativeTo(null); // zentriere das Fenster
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setze den Exit Button (X) auf "EXIT_ON_CLOSE" um das Programm ordentlich zu beenden
		frame.setResizable(false); // ausschalten vom maximieren des Fensters
		frame.setVisible(true); // zeige das Fenster an
		frame.addKeyListener(this); // fuege den Keylistener in das JFrame ein
	}

	public void keyPressed(KeyEvent e) { // wenn eine Taste gedrueckt wird
		Move move = new Move(); // deklarieren eines neuen Objektes "move" von der Klasse "Move"
		move.keyboard(e); // fuehre die Methode "keyboard" aus
		Move2 move2 = new Move2();
		move2.keyboard(e);
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}