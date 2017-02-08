package com.mayank.jdash.view;

import java.io.IOException;

import com.mayank.jdash.Main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Clock extends Application {
	private BorderPane Clock;
	private Stage clockStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.clockStage = primaryStage;
		this.clockStage.setTitle("jDash > Clock");
		
		initRootLayout();
		
		showClock();
	}
	
	/* INIT ROOT LAYOUT*/	
	public void initRootLayout(){
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Clock.class.getResource("view/RootLayout.fxml"));
            Clock = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(Clock);
            clockStage.setScene(scene);
            clockStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	/* SHOW DASH IN ROOT */
	public void showClock(){
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Clock.class.getResource("view/clock/Clock.fxml"));
            AnchorPane Dash = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            Clock.setCenter(Dash);

            // Give the controller access to the main app.
            DashController controller = loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	/* RETURN MAIN STAGE*/
	public Stage getPrimaryStage(){
		return clockStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}