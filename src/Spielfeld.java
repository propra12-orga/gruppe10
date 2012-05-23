import java.awt.GridLayout;
import javax.swing.*;

public class Spielfeld extends JFrame {
    public static void main(String[] args) {
    	
    	BomberManMove bomberManMove = new BomberManMove();
    	bomberManMove.bomberManMove();
    	
    	new Spielfeld();
    }
    
        public Spielfeld() {
        	JPanel panel = new JPanel(new GridLayout(11, 11, 0, 0)); // anlegen vom Gridlayout

            for (int i = 0; i < 121; i++) {
                JLabel label = new JLabel(new ImageIcon("images/bild2.png"), JLabel.CENTER); // Darstellung der Bilder
                panel.add(label); // einfuegen der Bilder in das Gridlayout
            }
                
                setContentPane(panel); // hinzufuegen des fertigen Gridlayout- + Bilderkonstruktes
                setTitle("BOMBERMAN"); // Fenstertitel
                setSize(550, 550); // Fenstergroesse
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true); // Sichtbarkeit auf true setzen
        }
}