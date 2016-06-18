package test;

import java.io.IOException;

import test.Sprite;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import resourceLoader.ResourceManager;
import resourceLoader.ResourceObject;

public class Test extends Application
{
	
	ResourceManager manager;
	
	public static void main(String[] args) throws IOException
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		try
		{
		ResourceManager.initalize("Test.txt");
		manager = ResourceManager.manager;
		manager.loadAll();
		
		Group root = new Group();
		Scene scene  = new Scene(root);
		primaryStage.setScene(scene);
		
		ImageView view = manager.getSprite("kaiya");
		root.getChildren().add(view);
		
		System.out.println(manager.getResourceMap().keySet());	
		primaryStage.show();
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
