import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Netz {
	public KeyEvent e;
	public byte[] data = new byte[ 1024 ]; 

	public void hoeren() throws IOException {
		
		Spielfeld.socket = new DatagramSocket( 4242 ); 

		while(true) {
			DatagramPacket packet = new DatagramPacket( data, data.length ); 
			try {Spielfeld.socket.receive( packet );
	    	} catch (SocketException se) {
	    		System.out.println("Exception abgefangen");
	    		Spielfeld.socket.disconnect();
	    		Spielfeld.socket = new DatagramSocket( 4242 );
	    		}
			String s = new String(packet.getData()); 
			s = s.trim();
			System.out.println(s);
			if(s.equals("links") == true){
				if(Menu.anzahlSpieler == 1){
					Spielfeld.anweisung = 65;
					Spielfeld.m.keyboard(e);
				}
				else if(Menu.anzahlSpieler == 2){
					Spielfeld.anweisung = 37;
					Spielfeld.m2.keyboard(e);
				}
			}
			if(s.equals("rechts") == true){
				if(Menu.anzahlSpieler == 1){
					Spielfeld.anweisung = 68;
					Spielfeld.m.keyboard(e);
					
				}
				else if(Menu.anzahlSpieler == 2){
					Spielfeld.anweisung = 39;
					Spielfeld.m2.keyboard(e);
				}
			}

			if(s.equals("hoch") == true){
				if(Menu.anzahlSpieler == 1){
					Spielfeld.anweisung = 87;
					Spielfeld.m.keyboard(e);
				}
				else if(Menu.anzahlSpieler == 2){
					Spielfeld.anweisung = 38;
					Spielfeld.m2.keyboard(e);
				}
			}

			if(s.equals("runter") == true){
				if(Menu.anzahlSpieler == 1){
					Spielfeld.anweisung = 83;
					Spielfeld.m.keyboard(e);
				}
				else if(Menu.anzahlSpieler == 2){
					Spielfeld.anweisung = 40;
					Spielfeld.m2.keyboard(e);
				}
			}
			if(s.equals("bombe") == true){
				if(Menu.anzahlSpieler == 1){
					Spielfeld.anweisung = 81;
					Spielfeld.m.keyboard(e);
				}
				else if(Menu.anzahlSpieler == 2){
					Spielfeld.anweisung = 32;
					Spielfeld.m2.keyboard(e);
				}
			}
		}
	}

	public void senden(KeyEvent e) throws IOException {
		String s = "";
        InetAddress ia = InetAddress.getByName( "localhost" ); 
       if(e.getKeyCode()==37||e.getKeyCode()==65) {
        s = "links";
       }
       if(e.getKeyCode()==39||e.getKeyCode()==68) {
           s = "rechts";
          }
       if(e.getKeyCode()==38||e.getKeyCode()==87) {
           s = "hoch";
          }
       if(e.getKeyCode()==40||e.getKeyCode()==83) {
           s = "runter";
          }
       if(e.getKeyCode()==32||e.getKeyCode()==81) {
           s = "bombe";
          }
       byte[] raw = s.getBytes(); 
        DatagramPacket packet = new DatagramPacket( raw, raw.length, ia, 4242 ); 
        DatagramSocket dSocket = new DatagramSocket(); 
        dSocket.send( packet ); 
        System.out.println( "Angabe abgeschickt" );
     }
}