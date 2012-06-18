import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu implements ActionListener {
	public Menu() {
		start1.add(startl1);
		start1.setSize(50, 30);
		start1.addActionListener(this);
		
		start2.add(startl2);
		start2.setSize(50, 30);
		start2.addActionListener(this);

		JButton options = new JButton();
		options.add(optionsl);
		options.setSize(50, 30);

		exit.add(exitl);
		exit.setSize(50, 30);
		exit.addActionListener(this);

		JPanel panel = new JPanel();

		panel.add(label);
		panel.add(start1);
		panel.add(start2);
		panel.add(exit);

		frame.setSize(550, 550);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}

	JButton start1 = new JButton();
	JButton start2 = new JButton();
	JButton exit = new JButton();

	JFrame frame = new JFrame("BOMBERWOMAN | Menu");

	JLabel label = new JLabel("Bomberwoman Version 0.60");
	JLabel startl1 = new JLabel("1 Spieler");
	JLabel startl2 = new JLabel("2 Spieler");
	JLabel optionsl = new JLabel("Options");
	JLabel exitl = new JLabel("Exit");

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start1) new Spielfeld(1);
		if(e.getSource() == start2) new Spielfeld(2);
		if(e.getSource() == exit) frame.dispose();
	}
}
