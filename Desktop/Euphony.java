
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;




import java.awt.event.*;
import javax.swing.*;
import java.net.URL;


import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;


public class Euphony extends Application {

    private static final Color color = Color.web("#344577");
    Button playSong = new Button("Play");
    DropShadow shadow = new DropShadow();
    Label label = new Label();
	MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
		
		//Color myColor=new Color(100,100,100);
		int height=400;
		int width=240;
        Scene scene = new Scene(new Group(),width,height,color);
        stage.setTitle("EUPHONY");
        //stage.setWidth(300);
        //stage.setHeight(300);

        label.setFont(Font.font("Times New Roman", 22));
        label.setTextFill(color);

        //Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
        //Image imageAccept = new Image(getClass().getResourceAsStream("ok.png"));

        VBox vbox = new VBox();
        vbox.setLayoutX(20);
        vbox.setLayoutY(20);
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
		HBox hbox3 = new HBox();

        Button createHotspot = new Button("Create Hotspot");
        createHotspot.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        createHotspot.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
				final String createWlan="netsh wlan set hostednetwork mode=allow ssid=euphony key=password";
				final String startWlan="netsh wlan start hostednetwork";
				String path="";
				try
				{
					//execute cmd command in cmd
					Runtime.getRuntime().exec(createWlan);
					Runtime.getRuntime().exec(startWlan);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
            }
        });


        Button selectSong = new Button("Select Song");
		selectSong.setStyle("-fx-font: 18 arial; -fx-base: #56789a;");
        selectSong.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               
			   
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
				
			   
			   
            }
        });

        playSong.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                 	mediaPlayer.play();	 
            }
        });

        playSong.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                playSong.setEffect(shadow);
            }
        });

        playSong.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                playSong.setEffect(null);
            }
        });


        hbox1.getChildren().add(selectSong);
        //hbox1.getChildren().add(playSong);
        //hbox1.getChildren().add(label);
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.BOTTOM_CENTER);

        Button pauseSong = new Button("Pause");
        //pauseSong.setGraphic(new ImageView(imageAccept));
        pauseSong.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mediaPlayer.pause();
            }
        });
		
		pauseSong.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                pauseSong.setEffect(shadow);
            }
        });

        pauseSong.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                pauseSong.setEffect(null);
            }
        });
		
		


        Button stopSong = new Button("Stop");
        //stopSong.setGraphic(new ImageView(imageDecline));
        stopSong.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                mediaPlayer.stop();
            }
        });
		
		
		stopSong.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                stopSong.setEffect(shadow);
            }
        });

        stopSong.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                stopSong.setEffect(null);
            }
        });
		
		
		
		
		
		
		
		
		
		
		
		Button connectDevice = new Button("Add Device");
        connectDevice.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        connectDevice.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
				
				
				
            }
        });
		
		
		

        hbox2.getChildren().add(playSong);
       
		hbox2.getChildren().add(pauseSong);
        hbox2.getChildren().add(stopSong);
        hbox2.setSpacing(25);

		hbox3.setAlignment(Pos.BOTTOM_CENTER);
		hbox3.getChildren().add(connectDevice);
       

        vbox.getChildren().add(createHotspot);
        vbox.getChildren().add(hbox1);
        vbox.getChildren().add(hbox2);
		vbox.getChildren().add(hbox3);
        vbox.setSpacing(20);
        ((Group)scene.getRoot()).getChildren().add(vbox);

        stage.setScene(scene);
        stage.show();
    }
}