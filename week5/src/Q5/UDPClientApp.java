package Q5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClientApp {

	public static void main(String[] args) {
		
		System.out.println("[UDP Client Side]");
		
		try {

			// Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// Get IP address
			InetAddress ip = InetAddress.getLocalHost();
			
			// Declare port no
			int portNo = 6142;

			// Convert the String input into the byte array
			String text = "UDP Client-Server Application Words Counter";
			byte buf[] = text.getBytes();

			// Wrap data in datagram packet 
			DatagramPacket outPacket = new DatagramPacket(buf, buf.length, ip, portNo);

			// Send datagram packet to server
			System.out.println("\nSending '" + text + "' to the server.\n");
			datagramSocket.send(outPacket);
			
			// Create object UDP to receive from server
			byte receiveBuf [] = new byte [2048];
			DatagramPacket receivePacket = new DatagramPacket (receiveBuf, receiveBuf.length);
			
			// Receive data from server side
			datagramSocket.receive(receivePacket);
			
			// Receive result number of word from server
			String wordsCount = new String (receivePacket.getData());
			
			// Display result
			System.out.print("Number of words is : " +wordsCount);
			
			datagramSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}