import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Spielfeld extends JFrame implements KeyListener {
    public static void main(String[] args) {

    	new Spielfeld();    	
    }
	
    
        public Spielfeld() {
        	
        	JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); // anlegen vom Gridlayout
        	
        	setContentPane(panel); // hinzufuegen des fertigen Gridlayout- + Bilderkonstruktes
            setTitle("BOMBERMAN"); // Fenstertitel
            setSize(550, 550); // Fenstergroesse
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true); // Sichtbarkeit auf true setzen
            
            addKeyListener(this); // einfügen des KeyListeners
			requestFocus(); // Fokus anfordern, sonst geht der KeyListener nicht
           
            for (int i = 0; i < 121; i++) {
                JLabel label = new JLabel(new ImageIcon("images/bild2.png"), JLabel.CENTER); // Darstellung der Bilder
                panel.add(label); // einfuegen der Bilder in das Gridlayout
            }
        }
        
        
        public boolean up, down, left, right;
	    
	    public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT && !right) {
				left = true;
				System.out.println("links");
			} else if (key == KeyEvent.VK_RIGHT && !left) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
				right = true;
				System.out.println("rechts");
			} else if(key == KeyEvent.VK_UP && !down) {
				up = true;
				System.out.println("hoch");
			} else if (key == KeyEvent.VK_DOWN && !up) {
				down = true;
				System.out.println("runter");
			} else {
				System.out.println("andere Taste");
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {
				left = false;
			} else if (key == KeyEvent.VK_RIGHT) {
				right = false;
			} else if(key == KeyEvent.VK_UP) {
				up = false;
			} else if (key == KeyEvent.VK_DOWN) {
				down = false;
			}
		}

		public void keyTyped(KeyEvent e) {
			
		}
}