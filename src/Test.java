// Ich weiss, dass das ein String-Array ist, jeodoch wie ist es möglich daraus ein Bild-Array zu machen, der dann auch noch (als Swing) oder sonst was in JFrame angezeigt wird?

public class Test {
	static int zeile = 10;
	static int spalte = 10;
	static String[][] spielfeld = new String[zeile][spalte];
	
	public static void main(String[] args) {
		updatespielfeld();
		anzeige();
	}
	
	// Setzt das Spielfeld auf Anfang.
		public static void updatespielfeld(){
			for (int x=0; x<zeile; x++) {
				for (int y=0; y<spalte; y++) {
					spielfeld[x][y] = "Hier sollte ein Bild sein.";
				}
			}
		}
	
	// Zeichnet das Spielfeld
		public static void anzeige(){
			for (int x=0; x<zeile; x++) {
				System.out.println("  ");
				for (int y=0; y<spalte; y++) {
					System.out.print("  " + spielfeld[x][y]);
				}
			}
			
		}

}