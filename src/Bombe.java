import java.util.*;

public class Bombe {
	boolean gewinner1 = false, gewinner2 = false;

	private int rad, xPos, yPos;
	boolean zerstoert[] = new boolean[4];

	Timer timer = new Timer();

	public Bombe(int rad, int xPos, int yPos) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void explodiert() {
		if(Spielfeld.feld[xPos][yPos].bombe == false) return;
		
		timer.schedule(new ExplosionTask(rad, xPos, yPos), 500);

		Blockeigenschaft.explosion(xPos, yPos);

		for(int i = 0; i <= 3; i++)
			zerstoert[i] = false;

		for(int x = xPos + 1; x <= xPos + rad; x++) {
			if(Spielfeld.feld[x][yPos].wand == true) break;

			if(x >= 0 && x <= 10) {
				if(Spielfeld.feld[x][yPos].bombe == true) {
					new Bombe(rad, x, yPos).explodiert();
					Spielfeld.feld[x][yPos].bombe = false;
				}
				if(Spielfeld.feld[x][yPos].spieler1 == true) gewinner2 = true;
				if(Spielfeld.feld[x][yPos].spieler2 == true) gewinner1 = true;
				if(Spielfeld.feld[x][yPos].zerbrechen == true) zerstoert[0] = true;
				Blockeigenschaft.explosion(x, yPos);
			}			

			if(zerstoert[0] == true) break;
		}

		for(int x = xPos - 1; x >= xPos - rad; x--) {
			if(Spielfeld.feld[x][yPos].wand == true) break;

			if(x >= 0 && x <= 10) {
				if(Spielfeld.feld[x][yPos].bombe == true) {
					new Bombe(rad, x, yPos).explodiert();
					Spielfeld.feld[x][yPos].bombe = false;
				}
				if(Spielfeld.feld[x][yPos].spieler1 == true) gewinner2 = true;
				if(Spielfeld.feld[x][yPos].spieler2 == true) gewinner1 = true;
				if(Spielfeld.feld[x][yPos].zerbrechen == true) zerstoert[1] = true;
				Blockeigenschaft.explosion(x, yPos);
			}

			if(zerstoert[1] == true) break;
		}

		for(int y = yPos + 1; y <= yPos + rad; y++) {
			if(Spielfeld.feld[xPos][y].wand == true) break;

			if(y >= 0 && y <= 10) {
				if(Spielfeld.feld[xPos][y].bombe == true) {
					new Bombe(rad, xPos, y).explodiert();
					Spielfeld.feld[xPos][y].bombe = false;
				}
				if(Spielfeld.feld[xPos][y].spieler1 == true) gewinner2 = true;
				if(Spielfeld.feld[xPos][y].spieler2 == true) gewinner1 = true;
				if(Spielfeld.feld[xPos][y].zerbrechen == true) zerstoert[2] = true;
				Blockeigenschaft.explosion(xPos, y);
			}

			if(zerstoert[2] == true) break;
		}

		for(int y = yPos - 1; y >= yPos - rad; y--) {
			if(Spielfeld.feld[xPos][y].wand == true) break;

			if(y >= 0 && y <= 10) {
				if(Spielfeld.feld[xPos][y].bombe == true) {
					new Bombe(rad, xPos, y).explodiert();
					Spielfeld.feld[xPos][y].bombe = false;
				}
				if(Spielfeld.feld[xPos][y].spieler1 == true) gewinner2 = true;
				if(Spielfeld.feld[xPos][y].spieler2 == true) gewinner1 = true;
				if(Spielfeld.feld[xPos][y].zerbrechen == true) zerstoert[3] = true;
				Blockeigenschaft.explosion(xPos, y);
			}

			if(zerstoert[3] == true) break;
		}

		timer.schedule(new ExplosionTask(rad, xPos, yPos), 1000);

		if(gewinner1 && gewinner2)
			Funktion.draw();
		else if(gewinner1)
			Funktion.gewinner1();
		else if(gewinner2) Funktion.gewinner2();
	}
}
