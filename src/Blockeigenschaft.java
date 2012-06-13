import javax.swing.ImageIcon;

public class Blockeigenschaft {
	public static void rasen(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/rasen.png"));
		Spielfeld.feld[xPos][yPos].laufen = true;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void endpunkt(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/endpunkt.png"));
		Spielfeld.feld[xPos][yPos].laufen = true;
		Spielfeld.feld[xPos][yPos].endpunkt = true;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void broecklig(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/wandbreak.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = true;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void spieler1(int xPos, int yPos, String direction) {
		if(direction == "up") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanback.png"));
		else if(direction == "down") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwoman.png"));
		else if(direction == "left") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanleft.png"));
		else if(direction == "right") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanright.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = true;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void spieler2(int xPos, int yPos, String direction) {
		if(direction == "up") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanback2.png"));
		else if(direction == "down") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwoman2.png"));
		else if(direction == "left") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanleft2.png"));
		else if(direction == "right") Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bomberwomanright2.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = true;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void wand(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/wand2.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = true;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void bombe1(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bombe1.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = true;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void bombe2(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/Bombe2.png"));
		Spielfeld.feld[xPos][yPos].laufen = false;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = true;
		Spielfeld.feld[xPos][yPos].explosion = false;
	}
	
	public static void explosion(int xPos, int yPos) {
		Spielfeld.feld[xPos][yPos].setIcon(new ImageIcon("images/ExplosionPrototyp.png"));
		Spielfeld.feld[xPos][yPos].laufen = true;
		Spielfeld.feld[xPos][yPos].endpunkt = false;
		Spielfeld.feld[xPos][yPos].zerbrechen = false;
		Spielfeld.feld[xPos][yPos].spieler1 = false;
		Spielfeld.feld[xPos][yPos].spieler2 = false;
		Spielfeld.feld[xPos][yPos].wand = false;
		Spielfeld.feld[xPos][yPos].bombe = false;
		Spielfeld.feld[xPos][yPos].explosion = true;
	}
}
