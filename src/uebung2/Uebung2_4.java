package uebung2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;

import org.apache.commons.net.ntp.*;
import org.apache.commons.net.time.TimeTCPClient;

public class Uebung2_4 {

	public static void main(String[] args) {
		//run
		System.out.println(getTime("time.fu-berlin.de"));
		System.out.println(getTime("zeit.fu-berlin.de"));
		System.out.println(getTime("0.de.pool.ntp.org"));
		System.out.println(getTime("ntp.bcs2005.net"));
		System.out.println(getTime("dk.pool.ntp.org"));	
		System.out.println(getTime2("time.fu-berlin.de"));	
	}
	
	public static String getTime(String server) {
		try {
			//InetAdresse
			InetAddress adr = InetAddress.getByName(server);
			//NTP-Client wird erstellt
			NTPUDPClient con = new NTPUDPClient();
			//Aufbau der Verbindung + Zeitabfrage
			TimeInfo time = con.getTime(adr);
			//Umwandlung der Rückgabewerte
			NtpV3Packet time1 = time.getMessage();
			//Return
			return time1.toString() + " Stratum: " + time1.getStratum();
			
		} catch ( IOException e) {
			
			e.printStackTrace();
			return "";
		}
		
		
	}
	
	public static String getTime2(String server) {
		try {
			InetAddress adr = InetAddress.getByName(server);
			TimeTCPClient con = new TimeTCPClient();
			con.connect(server);
			Date a = new Date(con.getTime());
			
			return a.toString();
			
		} catch ( IOException e) {
			
			e.printStackTrace();
			return "";
		}
		
		
	}

}
