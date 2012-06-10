import java.util.*;

public class BombeTask extends TimerTask {
	
	private int rad, zeile, spalte;
	
	public BombeTask(int rad, int zeile, int spalte) {
		this.rad = rad;
		this.zeile = zeile;
		this.spalte = spalte;
	}
	public void run() {
		new Bombe(rad, zeile, spalte).explodiert();		
	}
}
