import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu implements ActionListener {

	public Menu() {
		start.add(startl);
		start.setSize(50, 30);
		start.addActionListener(this);

		JButton options = new JButton();
		options.add(optionsl);
		options.setSize(50, 30);

		JButton exit = new JButton();
		exit.add(exitl);
		exit.setSize(50, 30);

		JPanel panel = new JPanel();

		panel.add(label);
		panel.add(start);
		panel.add(options);
		panel.add(exit);

		frame.setSize(500, 500);
		frame.setLocation(500, 100);
		frame.setVisible(true);
		frame.add(panel);
	}

	JButton start = new JButton();

	JFrame frame = new JFrame("Menu");

	JLabel label = new JLabel("Bomberman Version 1.00");
	JLabel startl = new JLabel("Start");
	JLabel optionsl = new JLabel("Options");
	JLabel exitl = new JLabel("Exit");

	public static void main(String[] args) {

		Menu start = new Menu();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) new Spielfeld();
	}
}