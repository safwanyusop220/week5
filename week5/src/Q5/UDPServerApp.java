package Q5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPServerApp {

	public static void main(String[] args) {
		
		System.out.println("[UDP Server-Side Application]");
		System.out.println("Running...");
		System.out.println("Waiting for request from client...");
        
        try {
        	       
    		// Declaration of port no to received datagram packet
    		int portNo = 6142;
    		
    		// Create a socket to listen at port 6142
            DatagramSocket datagramSocket = new DatagramSocket(portNo);
        	
        	while (true) {
                
                // Variable to received data from port 6142
                byte[] receivedBuf = new byte[65535];
          
                // Datagram to hold received packet
                DatagramPacket receivedPacket = new DatagramPacket(receivedBuf, receivedBuf.length);
                
        // Received from client
		datagramSocket.receive(receivedPacket);
				
		// Retrieve data from packet 
		String retreiveMessage = new String(receivedPacket.getData());
		System.out.println("\nMessage from client is: " + retreiveMessage + ".\n");
				
		// Send data to Client		
		String sendWordCount = Integer.toString(countWords(retreiveMessage));
		System.out.println("Number of words is:  " + sendWordCount);
				
		
		byte sendBuffer[] = new byte[65535];				
		sendBuffer = sendWordCount.getBytes();
				
		// Get client ip address and port
		InetAddress clientIP = receivedPacket.getAddress();
		int clientPort = receivedPacket.getPort();
				
		// Create object UDP Datagram packet to send packet
		DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientIP, clientPort);
				
		//send datagram packet to client
		datagramSocket.send(sendPacket);
	            
        	}
				
		} catch (IOException e) {
				
			e.printStackTrace();
        }
        
       
    }
	
public static int countWords(String text) {
		
		String trim = text.trim();
        if (trim.isEmpty())
                return 0;
        return trim.split("\s+").length; // separate string around spaces
        
	}
}
