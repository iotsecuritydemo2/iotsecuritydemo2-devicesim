package com.ibm.iotdemo;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("AppUI.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("SceneDeviceSelection.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("SceneDeviceStart.fxml"));
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("SceneDeviceStart.fxml"));
    		
    		Parent root = loader.load();

			Scene scene = new Scene(root,600,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Context.get().setController(loader.getController());
			
			primaryStage.setTitle("Device Demo Application");
			primaryStage.setScene(scene);
			primaryStage.show();
			
	        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            @Override
				public void handle(WindowEvent we) {
	            	// 
	            }
	        });        
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
