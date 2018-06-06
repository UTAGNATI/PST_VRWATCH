package Chat;

import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		try {
			socket = new Socket("192.168.43.167", 2013);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host");
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection");
		}
		System.out.println("Connected");

		String textToServer = "";
		int i = 0;

		while (i < 100) {

			if(!(read.equals(null))) {
				textToServer = read.readLine();
				out.print(textToServer + "\r\n"); // send to server
				out.flush();
				i++;
			}
			
			System.out.println("test");
			
			System.out.println(in.readLine()); // read from server
		}

		out.close();
		in.close();
		read.close();
		socket.close();
	}
}