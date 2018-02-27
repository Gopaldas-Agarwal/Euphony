import java.io.*;
import java.net.*;
import java.util.*;

class serverUDP
{
	
	public static void main(String[] s)throws Exception
	{
		File file;
		byte[] buffer = new byte[20240];
		file = new File("song.mp3");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		byte [] IP= { (byte)192, (byte)168, (byte)173, (byte)119 };
		InetAddress address = InetAddress.getByAddress(IP);
		System.out.println(file.length());
		DatagramSocket clientSocket=null;
		
		try 
		{
			 clientSocket = new DatagramSocket(27271);
		} 
		catch (SocketException e1)
		{
			e1.printStackTrace();
		}
		int i=0;
		while ((bis.read(buffer, 0, buffer.length)) > -1) 
		{
			++i;
			DatagramPacket packet = new DatagramPacket(buffer,buffer.length, address, 27272);
			System.out.print(i+" ");
			try 
			{
				clientSocket.send(packet);
				Thread.sleep(2000);
				
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
				
		}	
	}
}


