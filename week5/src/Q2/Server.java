package Q2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class Server {


	public static void main(String[] args) {
		
			
			try {
				
				// Port to receive and respond to request
				int portNo = 3154;
				ServerSocket serverSocket = new ServerSocket(portNo);
				System.out.println("\n[Server Side]\n");
				System.out.println("Running...");
				System.out.println("Waiting for request from client...");
				
				String validationName;
				int itemProductID=1000;
				
				// Server need to be alive forever thus the while(true)
				while (true) {
					
					// Accept client request for connection
					Socket socket = serverSocket.accept();
					
					// Create input stream to read object
					ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
					
					// Read object from stream and cast to ItemProduct
					ItemProduct itemProduct = (ItemProduct) objectIS.readObject();
					
					// Create object for class Validation
					NameValidation nameValidation = new NameValidation();
					
					// To validate the name of object itemProduct 
					validationName = nameValidation.validateItemName(itemProduct);
					
					// Process object and give product ID
					itemProduct.setItemProductID(++itemProductID);
					
					
					// Create output stream to send object
					ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
					objectOS.writeObject(itemProduct);
					objectOS.writeObject(validationName);
					objectOS.flush();
					
					// Displaying result
					System.out.println("Validation Result: " + validationName);
					System.out.println("Ready for next request");
					
					// Close all streams
					objectIS.close();
					objectOS.close();
					
				}
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
	

	}

