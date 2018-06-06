import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Serveur {
	
	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;
		Scanner scanner = new Scanner(System.in);
		
		try {
		
			socketserver = new ServerSocket(2013);
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
			socketduserveur = socketserver.accept(); 
		        System.out.println("Client connecté");
			out = new PrintWriter(socketduserveur.getOutputStream());
			String message;
			String message_distant;
			
			in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
			BufferedReader read = new BufferedReader (new InputStreamReader (System.in));
			int i = 0;
			
			while (i < 100) {
				
		        System.out.println(in.readLine());
		        
		        if (!(read.equals(null))) {
		        	out.println(read.readLine());
		        	out.flush();
		        }
		        out.flush();
			}
			
				out.close();
				in.close();
		        socketduserveur.close();
		        socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
