import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
class client{
	public static void main(String[] args) throws SocketException,IOException,UnknownHostException{
		int send = 9999,receive = 1000;
		DatagramSocket datagramSocket = new DatagramSocket(send);
		InetAddress inetAddress = InetAddress.getLocalHost();
		while(true){
			byte data[] = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data,data.length);
			String message = new Scanner(System.in).nextLine();
			data = message.getBytes();
			datagramSocket.send(new DatagramPacket(data,data.length, inetAddress, receive));
			datagramSocket.receive(dp);
			System.out.println("-: "+new String(dp.getData(),0,dp.getLength()));
		}
		// datagramSocket.close();
	}
}