import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Spielfeld implements KeyListener {
	static int zeile = 1, spalte = 1, zeile2 = 9, spalte2 = 9;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); 
	public static Feld[][] feld = new Feld[11][11]; 
	
	public Spielfeld() {
		for(int x = 0; x < 11; x++) { 
			for(int y = 0; y < 11; y++) {
				if(x == 0 || x == 10 || y == 0 || y == 10 || (x % 2 == 0 && y % 2 == 0)) { 
					Spielfeld.feld[x][y] = new Feld(new ImageIcon("images/wand2.png"));
					Blockeigenschaft.wand(x, y);
					panel.add(feld[x][y]); 

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
				else { 
					feld[x][y] = new Feld(new ImageIcon("images/rasen.png"));
					Blockeigenschaft.rasen(x, y);
					panel.add(feld[x][y]);
				}
			}
		}
		Blockeigenschaft.spieler1(zeile, spalte, "down");
		Blockeigenschaft.spieler2(zeile2, spalte2, "up");
		Blockeigenschaft.endpunkt(5, 5);

		frame.add(panel);
		frame.setTitle("BOMBERWOMAN");
		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 
		frame.setVisible(true); 
		frame.addKeyListener(this); 
	}

	public void keyPressed(KeyEvent e) {
		Move move = new Move();
		move.keyboard(e);
		Move2 move2 = new Move2();
		move2.keyboard(e);
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
}