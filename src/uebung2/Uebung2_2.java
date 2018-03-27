package uebung2;

import java.io.IOException;
import java.net.*;

public class Uebung2_2 {

	public static void main(String[] args) {
		
		String[] urls = new String[10];
		urls[0]= "www.google.com";
		urls[1] = "www.hwr-berlin.de";
		urls[2] = "www.facebook.com";
		urls[3] = "www.difreg.bplaced.com";
		urls[4] = "www.youtube.com";
		urls[5] = "www.gutefrage.net";
		urls[6] = "www.reddit.com";
		urls[7] = "www.9gag.com";
		urls[8] = "www.wikipedia.org";
		urls[9] = "www.eclipse.org";
		
		for(int i = 0; i< urls.length; i++) {
			System.out.println(URL_TO_IP(urls[i]));
		}
		
		
		System.out.println(IP_TO_URL("62.217.47.181")); // BVG
		System.out.println(IP_TO_URL("172.217.19.68")); // Google
		System.out.println(IP_TO_URL("120.192.191.235")); // DT-Server
		System.out.println(IP_TO_URL("172.217.19.68"));
		System.out.println(IP_TO_URL("172.217.19.68"));
		System.out.println(IP_TO_URL("172.217.19.68"));
		System.out.println(IP_TO_URL("172.217.19.68"));
		System.out.println(IP_TO_URL("172.217.19.68"));
		System.out.println(IP_TO_URL("172.217.19.68"));
		
		
		
		

	}
	
	public static String URL_TO_IP(String url) {
		InetAddress address;
		try {
			address = InetAddress.getByName(url);
			long time = System.currentTimeMillis();
			int port = 80;
			
			Socket sock = new Socket(address, port);
			sock.close();	
			time = System.currentTimeMillis() - time;
			
			return("Connection ok. Ping: " + time + "ms " + " IP: " + address.getHostAddress() + " Host-Name: " + address.getHostName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}
	
	public static String IP_TO_URL(String ip) {
		InetAddress address;
		try {
			address = InetAddress.getByName(ip);
			long time = System.currentTimeMillis();
			int port = 80;
			
			Socket sock = new Socket(address, port);
			sock.close();	
			time = System.currentTimeMillis() - time;
			
			return("Connection ok. Ping: " + time + "ms " + " IP: " + address.getHostAddress() + " Host-Name: " + address.getHostName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}



}
