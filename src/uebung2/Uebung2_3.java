package uebung2;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.omg.CORBA_2_3.portable.OutputStream;

public class Uebung2_3 {

	public static void main(String[] args) {
		System.out.println(getTime("time.fu-berlin.de"));
		System.out.println(getTime("zeit.fu-berlin.de"));
		System.out.println(getTime("quasar.phys.yorku.ca"));
	}
	
	public static String getTime(String url) {
		InetAddress address;
		try {
			// Inet-Adresse
			address = InetAddress.getByName(url);
			long time = System.currentTimeMillis();
			//Port13: DTS-Port
			int port = 13;
			//Verbindungsaufbau
			Socket sock = new Socket(address, port);
			//Datenstrom (Input)
			InputStream in = sock.getInputStream();
			int len;
			byte[] b = new byte[100];
			while ((len = in.read(b)) != -1) {
			System.out.write(b, 0, len);
			}			
			// Versuch, Daten zu schreiben (Wirkungslos)
			java.io.OutputStream out =  sock.getOutputStream();
			out.write(01010101010);
			// Verbindung schließen
			out.close();
			in.close();
			sock.close();
			// Ping
			time = System.currentTimeMillis() - time;
			//Return
			return("Connection ok. Ping: " + time + "ms " + " IP: " + address.getHostAddress() + " Host-Name: " + address.getHostName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}

}
