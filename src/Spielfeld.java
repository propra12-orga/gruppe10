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
            
            addKeyListener(this); // einfuegen des KeyListeners
            
            ImageIcon feld[][] = new ImageIcon[11][11]; // Deklarieren eines Bilderarrays
        	JLabel label = new JLabel(); // Darstellung der Bilder
        	
            	for (int x=0; x<11; x++) { // zweidimensionale Schleife
    				for (int y=0; y<11; y++) {
    					 if (x == 0 || x == 10 || y == 0 || y == 10 || (x%2 == 0 && y%2 == 0)) { // Koordinaten für die Wände
                             feld[x][y] = new ImageIcon("images/bild2.png"); // Feld an der Stelle x, y bekommt dieses Bild zugewiesen
                             label = new JLabel(feld[x][y]); // hinzufuegen zum JLabel
                             panel.add(label); // einfuegen des JLabels
                             }
    					 else { // ansonten Rasen
    						 feld[x][y] = new ImageIcon("images/rasen.png");
                             label = new JLabel(feld[x][y]);
                             panel.add(label);
    					 }
    				}
    			
            	}
        }
        
        // KeyListener
        public boolean up, down, left, right;
	    
	    public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {
				left = true;
				System.out.println("links");
			}
			else if (key == KeyEvent.VK_RIGHT) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
				right = true;
				System.out.println("rechts");
			}
			else if (key == KeyEvent.VK_UP) {
				up = true;
				System.out.println("hoch");
			}
			else if (key == KeyEvent.VK_DOWN) {
				down = true;
				System.out.println("runter");
			}
			else {
				System.out.println("andere Taste");
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT) {
				left = false;
			}
			else if (key == KeyEvent.VK_RIGHT) {
				right = false;
			}
			else if (key == KeyEvent.VK_UP) {
				up = false;
			}
			else if (key == KeyEvent.VK_DOWN) {
				down = false;
			}
		}

		public void keyTyped(KeyEvent e) { // muss implementiert sein, kann aber leer bleiben, da keine Verwendung besteht
			
		}
}