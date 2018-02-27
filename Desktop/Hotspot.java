import java.io.*;

public class Hotspot
{
		public String wallpaperPath;
		public String path;
		public static void main(String... args)
		{
			//cmd coomand to create and start a hotspot
			final String createWlan="netsh wlan set hostednetwork mode=allow ssid=euphony key=password";
			final String startWlan="netsh wlan start hostednetwork";
			String path="";
			try
			{
				//execute cmd command in cmd
				Runtime.getRuntime().exec(createWlan);
				Runtime.getRuntime().exec(startWlan);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	
}