import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Feld extends JLabel {
	public boolean laufen = false;
	public boolean endpunkt = false;
	public boolean zerbrechen = false;
	public boolean spieler1 = false;
	public boolean spieler2 = false;
	public boolean wand = false;
	public boolean bombe = false;
	public boolean explosion = false;

	public Feld(ImageIcon imageIcon) {
		super(imageIcon);
	}
}