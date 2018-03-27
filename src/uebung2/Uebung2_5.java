package uebung2;

import java.io.*;
import java.net.Socket;

public class Uebung2_5 {

	public static void main(String[] args) {
		getWebsite("www.hwr-berlin.de", "");

	}
	
	public static void getWebsite(String site, String header) {
		try {
			Socket sock = new Socket(site, 80);
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			//GET-Kommando senden
			String s = "GET " + header + " HTTP/1.0" +
			"\r\n\r\n";
			out.write(s.getBytes());
			//Ausgabe lesen und anzeigen
			int len;
			byte[] b = new byte[100];
			while ((len = in.read(b)) != -1) {
			System.out.write(b, 0, len);
			
			}
		}
		catch(Exception e){
			System.out.println("Download failed");
		}
	}

}
