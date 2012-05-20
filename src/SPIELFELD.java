import javax.swing.JFrame;
import javax.swing.JLabel;


public class SPIELFELD extends JFrame{
	public static void main(String[] args) {
		new SPIELFELD();
	}		
		
	public SPIELFELD() {
		setTitle("BOMBERMAN"); // Fenstertitel
		setSize(500, 500); // Fenstergröße
		setVisible(true); // Sichtbarkeit auf true setzen
		
		JLabel inhalt = new JLabel();
		inhalt.setText("Hier kommt der Inhalt hin");
	
		add(inhalt); // hinzufügen von inhalt zum Fenster
	}
}