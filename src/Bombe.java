import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bombe {

	boolean gewinner1 = false;
	boolean gewinner2 = false;
	JLabel winlabel = new JLabel();
	JPanel winpanel = new JPanel();
	private int rad, xPos, yPos;

	public Bombe(int rad, int xPos, int yPos) {

		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void explodiert() {

		for (int x = xPos - rad; x <= xPos + rad; x++) {
			if (x >= 0 && x <= 10 && Spielfeld.feld[x][yPos].zerbrechen == true) {
				Spielfeld.feld[x][yPos].setIcon(new ImageIcon("images/rasen.png"));
				Spielfeld.feld[x][yPos].laufen = true;
			}
			if (x >= 0 && x <= 10 && Spielfeld.feld[x][yPos].spieler1 == true) {
				gewinner2 = true;
			}
			if (x >= 0 && x <= 10 && Spielfeld.feld[x][yPos].spieler2 == true) {
				gewinner1 = true;
			}
		}

		for (int y = yPos - rad; y <= yPos + rad; y++) {
			if (y >= 0 && y <= 10 && Spielfeld.feld[xPos][y].zerbrechen == true) {
				Spielfeld.feld[xPos][y].setIcon(new ImageIcon("images/rasen.png"));
				Spielfeld.feld[xPos][y].laufen = true;
			}

			if (y >= 0 && y <= 10 && Spielfeld.feld[xPos][y].spieler1 == true) {
				gewinner2 = true;
			}
			if (y >= 0 && y <= 10 && Spielfeld.feld[xPos][y].spieler2 == true) {
				gewinner1 = true;
			}
		}

		if (gewinner1 && gewinner2){
			Spielfeld.panel.removeAll();
			//winlabel.setIcon(new ImageIcon("images/gewonnen1.png"));
			winpanel.add(winlabel);
			Spielfeld.frame.add(winpanel);
			Spielfeld.frame.revalidate();
			
			System.out.println("Draw");
		}
			

		else if (gewinner1) {
			Spielfeld.panel.removeAll();
			winlabel.setIcon(new ImageIcon("images/gewonnen1.png"));
			winpanel.add(winlabel);
			Spielfeld.frame.add(winpanel);
			Spielfeld.frame.revalidate();
		}

		else if (gewinner2) {
			Spielfeld.panel.removeAll();
			winlabel.setIcon(new ImageIcon("images/gewonnen2.png"));
			winpanel.add(winlabel);
			Spielfeld.frame.add(winpanel);
			Spielfeld.frame.revalidate();
		}
	}
}
