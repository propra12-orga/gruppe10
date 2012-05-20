import java.awt.GridLayout;
import javax.swing.*;

public class SPIELFELD extends JFrame{
    public static void main(String[] args) {
    	new SPIELFELD();
    }
    
        public SPIELFELD() {
        	JPanel panel = new JPanel(new GridLayout(10, 10, 0, 0)); // anlegen vom Gridlayout

            for (int i = 0; i < 100; i++) {
                JLabel label = new JLabel(new ImageIcon("images/bild.png"), JLabel.CENTER); // Bild wird als Array angezeigt
                panel.add(label); // hinzufügen vom Gridlayout
            }
                
                setContentPane(panel); // hinzufügen der Bilder
                setTitle("BOMBERMAN"); // Fenstertitel
                setSize(500, 500); // Fenstergröße
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true); // Sichtbarkeit auf true setzen
        }
}