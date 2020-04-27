package client;

import GUI.ClientController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } 
	
	@Override
	public void start(Stage primaryStage) throws Exception {			  		
		ClientController aFrame = new ClientController(); 
		// create StudentFrame
		aFrame.start(primaryStage);
		
	}

}
