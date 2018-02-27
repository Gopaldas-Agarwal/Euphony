import java.net.URL;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.*;


public class PlaySong extends Application {
	
	MediaPlayer mediaPlayer;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//URL resource = getClass().getResource("song.mp3");
		
		//SELECT A FILE USING  JFILECHOOSER
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		String path = file.getAbsolutePath();
		path = path.replace("\\", "/");
		path="file:/" + path;
		path=path.replace(" ","%20");
		System.out.println(path);
		
		Media media = new Media(path);
		String directory = System.getProperty("user.dir") + System.getProperty("file.separator");
		System.out.println(directory );
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		//Media media = new Media(resource.toString());
		//Media media = new Media("file:/F:/song.mp3");
	
	
	}
	public void playSong()
	{
		mediaPlayer.play();
	}
	public void pauseSong()
	{
		mediaPlayer.pause();
	}
	public void stopSong()
	{
		mediaPlayer.stop();
	}
}