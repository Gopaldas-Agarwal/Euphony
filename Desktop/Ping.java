import java.io.*;
import javax.imageio.*;
import java.net.*;

public class Ping
{
		public String wallpaperPath;
		public String path;
		String currentIP,subnet;
		
		Ping()
		{			
            
			try
			{
				currentIP = InetAddress.getLocalHost().toString();
				//subnet = getSubnet(currentIP);
				subnet="192.168.173.";
				System.out.println(currentIP + " : " + subnet);
			}
			catch(Exception e){}
			for(int i=150;i<200;++i)
			{
                String host = subnet + i;
				String cmdCommand="ping -n 2 "+host;
				String result="";;
				String find="Received = 0";
				try
				{
					Process process = Runtime.getRuntime().exec(cmdCommand);
					//read the result of thee command 
					StreamReader reader = new StreamReader(process.getInputStream());	
					//convert the inputstream object to string			
					reader.start();
					process.waitFor();
					reader.join();
					result = reader.getResult();
					String reply="Reply from "+host+": bytes";
					if(result.contains(reply))
					{
						System.out.println(host+" Reachable : ");
					}
					else
					{
						//System.out.println(host+" unreachable : ");
					}
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	
		
	    public String getSubnet(String currentIP) 
		{
			int firstSeparator = currentIP.lastIndexOf("/");
			int lastSeparator = currentIP.lastIndexOf(".");
			return currentIP.substring(firstSeparator+1, lastSeparator+1);
	    }

		
		
		public static void main(String... args)
		{
			new Ping();
		}
		
		
		
		//class to convert InputStream object to StringWriter
		static class StreamReader extends Thread 
		{
			private InputStream is;
			private StringWriter sw;
		
			StreamReader(InputStream is)
			{
				this.is = is;
			  	sw = new StringWriter();
			}
		
			public void run() 
			{
				try 
				{
					int c;
					while ((c = is.read()) != -1)
					  sw.write(c);
				}
			catch (IOException e) { ; }
		}
		
		String getResult() 
		{
			  return sw.toString();
		}
	}
}