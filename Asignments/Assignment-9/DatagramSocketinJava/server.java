import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
class server{ 
	public static void main(String[] args) throws SocketException,IOException,UnknownHostException{
		int send = 9999,receive = 1000;
		
		DatagramSocket datagramSocket = new DatagramSocket(receive);
		
		InetAddress inetAddress = InetAddress.getLocalHost();
		while(true){
			byte data[] = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data,data.length);
			datagramSocket.receive(dp);
			System.out.println("-: "+new String(dp.getData(),0,dp.getLength()));
			String message = new Scanner(System.in).nextLine();
			datagramSocket.send(new DatagramPacket(message.getBytes(),message.length(), inetAddress, send));
		}
		// datagramSocket.close();
	}
}