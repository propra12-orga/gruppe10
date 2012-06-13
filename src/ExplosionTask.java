import java.util.*;

public class ExplosionTask extends TimerTask {
	private int rad, xPos, yPos;

	public ExplosionTask(int rad, int xPos, int yPos) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void run() {
		Blockeigenschaft.rasen(xPos, yPos);
		
		for(int x = xPos + 1; x <= xPos + rad; x++) {
			if(Spielfeld.feld[x][yPos].wand == true) break;

			if(x >= 0 && x <= 10 && Spielfeld.feld[x][yPos].laufen == true) {
				Blockeigenschaft.rasen(x, yPos);
			}
		}

		for(int x = xPos - 1; x >= xPos - rad; x--) {
			if(Spielfeld.feld[x][yPos].wand == true) break;

			if(x >= 0 && x <= 10 && Spielfeld.feld[x][yPos].laufen == true) {
				Blockeigenschaft.rasen(x, yPos);
			}
		}
		for(int y = yPos + 1; y <= yPos + rad; y++) {
			if(Spielfeld.feld[xPos][y].wand == true) break;

			if(y >= 0 && y <= 10 && Spielfeld.feld[xPos][y].laufen == true) {
				Blockeigenschaft.rasen(xPos, y);
			}
		}

		for(int y = yPos - 1; y >= yPos - rad; y--) {
			if(Spielfeld.feld[xPos][y].wand == true) break;

			if(y >= 0 && y <= 10 && Spielfeld.feld[xPos][y].laufen == true) {
				Blockeigenschaft.rasen(xPos, y);
			}
		}
	}
}
