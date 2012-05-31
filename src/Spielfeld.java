import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Spielfeld extends JFrame implements KeyListener {
    
	public static void main(String[] args) {
    	
    	new Spielfeld();
    }
	
	
    int zeile = 1, spalte = 1;
    JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); // anlegen vom Gridlayout
    public Feld[][] feld = new Feld[11][11]; // 11 mal 11 JLabel
    
        public Spielfeld() {
        	
            	for (int x = 0; x < 11; x++) { // zweidimensionale Schleife
    				for (int y = 0; y < 11; y++) {
    					 if (x == 0 || x == 10 || y == 0 || y == 10 || (x % 2 == 0 && y % 2 == 0)) { // Koordinaten für die Wände
                             feld[x][y] = new Feld (new ImageIcon("images/bild2.png")); // feld (JLabel) an der Stelle x, y bekommt dieses Bild zugewiesen
                             feld[x][y].laufen = false;
                             panel.add(feld[x][y]); // einfuegen von JLabel in das JPanel
                             }
    					 else { // ansonten Rasen
    						 feld[x][y] = new Feld (new ImageIcon("images/gras.png"));
    						 feld[x][y].laufen = true;
    						 panel.add(feld[x][y]);
    					 }
    				}
            	}
            	
            feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwoman.png")); // Spielfigur
            
            feld[9][9].setIcon(new ImageIcon("images/endpunkt.png")); // Endpunkt
            feld[9][9].endpunkt = true;
            
            setContentPane(panel); // hinzufuegen des fertigen Gridlayout- + Bilderkonstruktes
            setTitle("BOMBERWOMAN"); // Fenstertitel
            setSize(550, 550); // Fenstergroesse
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false); // maximieren verbieten, damit das Spiel nicht unschoen aussieht
            setVisible(true); // Sichtbarkeit auf true setzen
            
            addKeyListener(this); // einfuegen des KeyListeners
        }
        
        
        // KeyListener
        public boolean up, down, left, right;
	    
	    public void keyPressed(KeyEvent e) {
	    	
			int key = e.getKeyCode();
			if ((key == KeyEvent.VK_LEFT) && (feld[zeile][spalte - 1].laufen)) {
				left = true;
				System.out.println("links");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png")); // Gras an die Stelle, von der Bomberwoman kommt
				spalte--;
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanleft.png"));
				
				if (feld[zeile][spalte].endpunkt) { // Endpunktcheck
					System.out.println("Endpunkt");
				}
			}
			else if ((key == KeyEvent.VK_RIGHT) && (feld[zeile][spalte + 1].laufen)) { // else if, damit das Programm nicht jede if Bedingung einzeln durchgehen muss
				right = true;
				System.out.println("rechts");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				spalte++; // spalte wird um 1 erhöht
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanright.png"));
				
				if (feld[zeile][spalte].endpunkt) {
					System.out.println("Endpunkt");
				}
			}
			else if ((key == KeyEvent.VK_UP) && (feld[zeile - 1][spalte].laufen)) {
				up = true;
				System.out.println("hoch");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				zeile--; // zeile wird um 1 verringert
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwomanback.png"));
				
				if (feld[zeile][spalte].endpunkt) {
					System.out.println("Endpunkt");
				}
			}
			else if ((key == KeyEvent.VK_DOWN) && (feld[zeile + 1][spalte].laufen)) {
				down = true;
				System.out.println("runter");
				feld[zeile][spalte].setIcon(new ImageIcon("images/gras.png"));
				zeile++;
				feld[zeile][spalte].setIcon(new ImageIcon("images/Bomberwoman.png"));
				
				if (feld[zeile][spalte].endpunkt) {
					System.out.println("Endpunkt");
				}
			}
			else {
				System.out.println("Wand oder falsche Taste");
			}
		}


		public void keyReleased(KeyEvent e) { // muss implementiert sein, kann aber leer bleiben, da keine Verwendung besteht

		}
		
		public void keyTyped(KeyEvent e) {
			
		}
}