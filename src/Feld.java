import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Feld extends JLabel {
	
	public boolean laufen;
	public boolean endpunkt = false;
	
	
	public Feld(ImageIcon imageIcon) {
		
		super(imageIcon);
	}
}