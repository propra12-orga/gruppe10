import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Feld extends JLabel {
	public boolean laufen = false, endpunkt = false, zerbrechen = false, spieler1 = false, spieler2 = false, wand = false, bombe = false, explosion = false;

	public Feld(ImageIcon imageIcon) {
		super(imageIcon);
	}
}