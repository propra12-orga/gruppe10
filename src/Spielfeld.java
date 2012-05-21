import java.awt.GridLayout;
import javax.swing.*;

public class Spielfeld extends JFrame {
    public static void main(String[] args) {
    	new Spielfeld();
    }
    
        public Spielfeld() {
        	JPanel panel = new JPanel(new GridLayout(10, 10, 0, 0)); // anlegen vom Gridlayout

            for (int i = 0; i < 100; i++) {
                JLabel label = new JLabel(new ImageIcon("images/bild2.png"), JLabel.CENTER); // Darstellung der Bilder
                panel.add(label); // einfuegen der Bilder in das Gridlayout
            }
                
            	new BomberManMove();
                setContentPane(panel); // hinzufuegen des fertigen Gridlayout- + Bilderkonstruktes
                setTitle("BOMBERMAN"); // Fenstertitel
                setSize(500, 500); // Fenstergroesse
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true); // Sichtbarkeit auf true setzen
        }
}