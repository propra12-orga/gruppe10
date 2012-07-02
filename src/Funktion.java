import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Funktion {
	static JLabel winlabel = new JLabel();
	static JPanel winpanel = new JPanel();

	public static void gewinner1() {
		Spielfeld.panel.removeAll();
		winlabel.setIcon(new ImageIcon("images/gewonnen1.png"));
		winpanel.add(winlabel);
		Spielfeld.frame.add(winpanel);
		Spielfeld.frame.revalidate();
	}

	public static void gewinner2() {
		Spielfeld.panel.removeAll();
		Funktion.winlabel.setIcon(new ImageIcon("images/gewonnen2.png"));
		Funktion.winpanel.add(winlabel);
		Spielfeld.frame.add(winpanel);
		Spielfeld.frame.revalidate();
	}

	public static void draw() {
		Spielfeld.panel.removeAll();
		winlabel.setIcon(new ImageIcon("images/Gleichstand.png"));
		winpanel.add(Funktion.winlabel);
		Spielfeld.frame.add(Funktion.winpanel);
		Spielfeld.frame.revalidate();
	}
}
