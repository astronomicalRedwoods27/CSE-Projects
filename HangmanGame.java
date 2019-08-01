import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class HangmanGame extends Application
{
	public void start(Stage primaryStage)
	{
		//creates a DrawPane object. See DrawingPane.java for details.
	      GamePane gui = new GamePane();
	   
	      // Creates a scene and places rootPane in the stage
	      Scene scene = new Scene(gui, 600, 600);
	      primaryStage.setTitle("GUI's Hangman"); 
	      primaryStage.setScene(scene); // Places the scene in the stage
	      primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
