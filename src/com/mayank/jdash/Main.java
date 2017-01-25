package com.mayank.jdash;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.mayank.jdash.view.DashController;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Mayank's Spectacular Life Hub Dashboard");
		this.primaryStage.setTitle("jDash");
		
		initRootLayout();
		
		showDash();
	}
	
	/* INIT ROOT LAYOUT*/
	public void initRootLayout(){
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/* SHOW DASH IN ROOT */
	public void showDash(){
		try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Dash.fxml"));
            AnchorPane Dash = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(Dash);

            // Give the controller access to the main app.
            DashController controller = loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/* RETURN MAIN STAGE*/
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
