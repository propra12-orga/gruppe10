import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BomberManMove implements KeyListener  {
	public void main (String[] args) {
	
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

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	}
	
}

	

	
	
	
