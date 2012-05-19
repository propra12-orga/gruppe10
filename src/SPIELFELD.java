import javax.swing.JFrame;
import javax.swing.JLabel;


public class SPIELFELD {
	public static void main(String[] args) {
		
		JFrame window = new JFrame(); // Erstellung eines Fensters
		window.setTitle("BOMBERMAN 2.0"); // Fenstertitel
		window.setSize(500, 500); // Fenstergröße
		window.setVisible(true); // Sichtbarkeit auf true setzen
		
		JLabel inhalt = new JLabel();
		inhalt.setText("Hier kommt der Inhalt hin");
	
		window.add(inhalt); // hinzufügen von inhalt zum Fenster
	}
}
