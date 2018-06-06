package Sock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public static void main(String[] zero) {
		
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;

		try {
		
			socket = new Socket("192.168.43.167",2010);	
		        System.out.println("Reception : On");

		        in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		        
		        String message_distant="";
		        
		        while(!(message_distant.equals("quit"))) {
		        	message_distant = in.readLine();
			        System.out.println(message_distant);
		        }
		        
		        socket.close();   
		       
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("Reception : Off");
		}
	}

}
