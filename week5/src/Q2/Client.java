package Q2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;




public class Client {

	
		public static void main(String[] args) {
			
			System.out.println("\n[Client Side]\n");

			// Request data
			ItemProduct itemProduct = new ItemProduct();
			itemProduct.setName("Nasi Ayam");
			itemProduct.setPrice(5);

			try {

				// Data to establish connection to server
				int portNo = 3154;
				InetAddress serverAddress = InetAddress.getLocalHost();

				// To connect to the server at localhost for port 3154
				Socket socket = new Socket(serverAddress, portNo);

				// Open stream to send object to the server
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());

				// Send request to the server
				System.out.println("Send object to server: " + itemProduct);
				objectOS.writeObject(itemProduct);
				objectOS.flush();
				
				// Create input stream to get object from server
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				// Receive object from server and display it
				itemProduct = (ItemProduct) objectIS.readObject();
				String validationName = (String)objectIS.readObject();
				
				
				// Displaying result
				System.out.println("\n\nValidation result : " +validationName +"\n");
				System.out.println ("Product ID: " + itemProduct.getItemProductID());
				System.out.println ("Product Name: "+itemProduct.getName());
				System.out.printf("Product Price: RM "+ "%.2f", itemProduct.getPrice());
				
				
				// Close all closeable objects
				objectOS.close();
				objectIS.close();
				socket.close();

			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("\n\n[End of application]");

		}

	}


