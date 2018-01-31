package katrenich.web;

import java.net.InetAddress;
import java.net.UnknownHostException;

//Demonstration class InetAddress
public class App00 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress iAdress = InetAddress.getLocalHost();
		System.out.println(iAdress);

		iAdress = InetAddress.getByName("ba.ua");
		System.out.println(iAdress + "\n");

//		InetAddress[] adress = InetAddress.getAllByName("google.com");
//		for (InetAddress i: adress) {
//			System.out.println(i);
//		}

	}
}
