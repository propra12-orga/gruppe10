import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu implements ActionListener {
	static int anzahlSpieler = 2;
	static boolean level1 = false;
	
	public Menu() {
		start1.add(startl1);
		start1.setSize(50, 30);
		start1.addActionListener(this);
		
		start2.add(startl2);
		start2.setSize(50, 30);
		start2.addActionListener(this);
		
		start3.add(startl3);
		start3.setSize(50, 30);
		start3.addActionListener(this);

		exit.add(exitl);
		exit.setSize(50, 30);
		exit.addActionListener(this);

		JPanel panel = new JPanel();

		panel.add(label);
		panel.add(start1);
		panel.add(start2);
		panel.add(start3);
		panel.add(exit);

		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}

	JButton start1 = new JButton();
	JButton start2 = new JButton();
	JButton start3 = new JButton();
	JButton exit = new JButton();

	JFrame frame = new JFrame("BOMBERWOMAN | Menu");

	JLabel label = new JLabel("Bomberwoman Version 0.68");
	JLabel startl1 = new JLabel("1 Spieler");
	JLabel startl2 = new JLabel("2 Spieler");
	JLabel startl3 = new JLabel("2 Spieler Free Run");
	JLabel optionsl = new JLabel("Options");
	JLabel exitl = new JLabel("Exit");

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start1) {
			anzahlSpieler = 1;
			level1 = true;
			Spielfeld spielfeld = new Spielfeld();
        	spielfeld.neuesSpielfeld(1, "level1.txt");
		}
		if(e.getSource() == start2) {
			level1 = true;
			Spielfeld spielfeld = new Spielfeld();
        	spielfeld.neuesSpielfeld(2, "level1.txt");
		}
		if(e.getSource() == start3) {
			Spielfeld spielfeld = new Spielfeld();
        	spielfeld.neuesSpielfeld(2, "freerun.txt");
		}
		if(e.getSource() == exit) frame.dispose();
	}
}
