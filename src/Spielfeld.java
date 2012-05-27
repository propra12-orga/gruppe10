import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Spielfeld extends JFrame implements KeyListener {
    public static void main(String[] args) {
    	
    	new Spielfeld();
    }
	
    Boolean laufen = true;
    int zeile = 1, spalte = 1;
    JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); // anlegen vom Gridlayout
    JLabel feld[][] = new JLabel[11][11]; // Darstellung der Bilder
    
        public Spielfeld() {
        	

        	setContentPane(panel); // hinzufuegen des fertigen Gridlayout- + Bilderkonstruktes
            setTitle("BOMBERWOMAN"); // Fenstertitel
            setSize(550, 550); // Fenstergroesse
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false); // maximieren verbieten, damit das Spiel nicht unschoen aussieht
            setVisible(true); // Sichtbarkeit auf true setzen
            
            addKeyListener(this); // einfuegen des KeyListeners
            
        	
            	for (int x=0; x<11; x++) { // zweidimensionale Schleife
    				for (int y=0; y<11; y++) {
    					 if (x == 0 || x == 10 || y == 0 || y == 10 || (x%2 == 0 && y%2 == 0)) { // Koordinaten für die Wände
                             feld[x][y] = new JLabel (new ImageIcon("images/bild2.png")); // Feld an der Stelle x, y bekommt dieses Bild zugewiesen
                             panel.add(feld[x][y]); // einfuegen des JLabels
                             }
    					 else { // ansonten Rasen
    						 feld[x][y] = new JLabel (new ImageIcon("images/gras.png")); // Feld an der Stelle x, y bekommt dieses Bild zugewiesen
    						 panel.add(feld[x][y]); // einfuegen des JLabels
                            
    					 }
    				}
            	}
            feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwoman.png")); // Spielfigur
        }
        
        
        // KeyListener
        public boolean up, down, left, right;
	    
	    public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT && laufen == true) {
				left = true;
				System.out.println("links");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png")); // Gras an die Stelle, von der Bomberwoman kommt
				spalte--;
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanleft.png"));
				validate();
			}
			else if (key == KeyEvent.VK_RIGHT && laufen == true) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
				right = true;
				System.out.println("rechts");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				spalte++; // spalte wird um 1 erhöht
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanright.png"));
			}
			else if (key == KeyEvent.VK_UP && laufen == true) {
				up = true;
				System.out.println("hoch");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				zeile--; // zeile wird um 1 verringert
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanback.png"));
			}
			else if (key == KeyEvent.VK_DOWN && laufen == true) {
				down = true;
				System.out.println("runter");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				zeile++;
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwoman.png"));
			}
			else {
				System.out.println("andere Taste");
			}
		}


		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) { // muss implementiert sein, kann aber leer bleiben, da keine Verwendung besteht
			
		}
}