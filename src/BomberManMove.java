import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BomberManMove implements KeyListener {

		public BomberManMove() {
			keyPressed(null);
			keyReleased(null);
			keyTyped(null);
		}
		
	
	public boolean up, down, left, right;
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT && !right) {
			left = true;
			System.out.println("LEFT");
		}
		if (key == KeyEvent.VK_RIGHT && !left) {
			right = true;
		}
		if(key == KeyEvent.VK_UP && !down) {
			up = true;
		}
		if (key == KeyEvent.VK_DOWN && !up) {
			down = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			left = false;
			System.out.println("LEFT-LOSGELASSEN");
		}
		if (key == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if(key == KeyEvent.VK_UP) {
			up = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			down = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	
	}
}
	

	
	
	
