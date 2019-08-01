import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.paint.*;

public class GamePane extends BorderPane
{
	private String[] listOne = {"a" ,"b" ,"c" ,"d" ,"e" ,"f", "g", "h", "i", "j",
								"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
								"u", "v", "w", "x", "y", "z", "1", "2", "3", "4", 
								"5", "6", "7", "8", "9", "0", " "}; // string array to hold all necessary character for buttons
	private Button[] listTwo; // button array to hold the buttons
	private Button setKeyword, resetGame; // buttons to set the secret keyword for the game and to reset the game
	private FlowPane alphabet; // holds buttons from listTwo 
	private Label keywordLabel; // title for keywordEntry, prompts user to enter in the keyword
	private TextField keywordEntry; // text field to enter in the keyword
	private String keyword; // string to be used in ButtonHandler
	private TextArea keywordDisplay; // used to display and update statues of keyword
	private TextArea resultDisplay; // used to display chances left as well as win/loss status
	private int strikes; // used to determine chances left untill loss of game
	private String[] tempArray; // used in ButtonHandler as a searchable String[]
	private boolean winStatus; // determines ability of user to win
	private Pane canvas; // area to draw picture in
	
	public GamePane() //  constructor
	{
		strikes = 0;
		winStatus = false;
		listTwo = new Button[37];
		for (int i = 0; i < listTwo.length; i++)
		{
			listTwo[i] = new Button(listOne[i]);
		}
		
		// creates a grid pane to hold the keyword of the game, and to start and rest the game as well.
		GridPane controlPane = new GridPane();
		keywordLabel = new Label("Enter keyword:");
		keywordEntry = new TextField();
		setKeyword = new Button("Start Game");
		setKeyword.minWidth(40.0);
		resetGame = new Button("Reset");
		controlPane.add(keywordLabel, 0, 0);
		controlPane.add(keywordEntry, 1, 0);
		controlPane.add(setKeyword, 2, 0);
		controlPane.add(resetGame, 3, 0);
		controlPane.setHgap(10); // setting hGap to 10 pixels
		controlPane.setPadding(new Insets (10, 10, 10, 10));
		
		// holds the keywordDisplay, resultDisplay, and canvas in the center of the GUI
		VBox centerPane = new VBox();
		HBox subPane = new HBox();
		keywordDisplay = new TextArea(" ");
		resultDisplay = new TextArea("");
		subPane.getChildren().addAll(keywordDisplay, resultDisplay);
		canvas = new Pane();
		centerPane.getChildren().addAll(subPane, canvas);
		
		// creates a FlowPane for all buttons to subside in
		alphabet = new FlowPane();
		for (int i = 0; i < listTwo.length; i++)
		{
			alphabet.getChildren().add(listTwo[i]);
		}
	    
		// adds all panes to the GamePane
		this.setTop(controlPane);
		this.setCenter(centerPane);
		this.setBottom(alphabet);
		
		// ties all buttons to ButtonHandler
	    for (int i = 0; i < listTwo.length; i++)
		{
	    	listTwo[i].setOnAction(new ButtonHandler());
		}
	    setKeyword.setOnAction(new ButtonHandler());
	    resetGame.setOnAction(new ButtonHandler());
	}
	
	public void resultChoice() // 8 strikes
	{
		strikes++; // initial counting of strikes, will increaseevery time the method is called.
		
		if(strikes == 1) // message dispalyed for first error
		{
			resultDisplay.appendText("Gallows appeared. 7 chances left.");
			// draws the gallows and adds it to canvas
			Line base = new Line(100,600,800,600);
			Line vert = new Line(300,100,300,600);
			Line horiz = new Line(300,100,500,100);
			Line down = new Line(500,100,500,200);
			canvas.getChildren().addAll(base,vert,horiz,down);
		}
		else if(strikes == 2) // message dispalyed for Second error
		{
			resultDisplay.appendText("\n\nHead appeared. 6 chances left.");
			// draws the head and adds it to canvas
			Circle head = new Circle(500,250,50);
			head.setFill(Color.WHITE);
			head.setStroke(Color.BLACK);
			canvas.getChildren().add(head);
		}
		else if(strikes == 3)
		{
			resultDisplay.appendText("\n\nBody appeared. 5 chances left.");
			// draws the body and adds it to canvas
			Line body = new Line(500,300,500,400);
			canvas.getChildren().add(body);
		}
		else if(strikes == 4)
		{
			resultDisplay.appendText("\n\nLeft Arm appeared. 4 chances left.");
			// draws the left leg and adds it to canvas
			Line leftArm = new Line(500,300,450,350);
			canvas.getChildren().add(leftArm);
		}
		else if(strikes == 5)
		{
			resultDisplay.appendText("\n\nRight Arm appeared. 3 chances left.");
			// draws the right arm and adds it to canvas
			Line rightArm = new Line(500,300,550,350);
			canvas.getChildren().add(rightArm);
		}
		else if(strikes == 6)
		{
			resultDisplay.appendText("\n\nLeft Leg appeared. 2 chances left.");
			// draws the left leg and adds it to canvas
			Line leftLeg = new Line(500,400,450,500);
			canvas.getChildren().add(leftLeg);
		}
		else if(strikes == 7)
		{
			resultDisplay.appendText("\n\nRight Leg appeared. 1 chances left.");
			// draws the right leg and adds it to canvas
			Line rightLeg = new Line(500,400,550,500);
			canvas.getChildren().add(rightLeg);
		}
		else if(strikes == 8)
		{
			resultDisplay.appendText("\n\nFace appeared. You lost. Please reset the game.");
			// creates eyes and mouth for the face
			Text leftEye = new Text(480,245,"X");
			Text rightEye = new Text(510,245,"X");
			Line mouth = new Line(480,265,520,265);
			canvas.getChildren().addAll(leftEye,rightEye,mouth);
		}
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> // A handler class used to handle events from Undo & Erase buttons
	{
        public void handle(ActionEvent event)
        {
            if (event.getSource() == setKeyword) // case for setting the keyword  
            {
            	keyword = keywordEntry.getText(); // creates a string out of user entered input
            	tempArray = new String[keyword.length()]; // converts keyword to a searchable String[]
            	for (int i = 0; i < keyword.length(); i++) // creates array of "_" with a length of keyword.length() 
            	{
            		tempArray[i] = "_ ";
            		keywordDisplay.appendText(tempArray[i]);
            	}
            	keywordEntry.setText(""); // clears keyWordEntry so keyword can't be seen
            	setKeyword.setDisable(true); // makes it so keyword cannot be changed midgame, unless reset is hit
            }
            if (event.getSource() == resetGame)  // case for resetting the game
            {
            	for (int i = 0; i < listTwo.length; i++)// runs through list two and re-enables the buttons
        		{
        			if (listTwo[i].isDisabled() == true)
        			{
        				listTwo[i].setDisable(false);
        			}
        		}
            	//resets all values and panes
            	strikes = 0;
            	winStatus = false;
            	setKeyword.setDisable(false);
            	keywordDisplay.clear();
            	resultDisplay.clear();
            	canvas.getChildren().clear();
            }
            else
            {
            	for (int i = 0; i < listTwo.length; i++) // checks through to see if what buttons are pressed.
                {
                	if (event.getSource() == listTwo[i]) // if button clicked is the button equivalent to listTwo[i] 
                	{
                			boolean checkTruth = false; // to check truth of the character being in the keywordDisplay 
                			for (int j = 0; j < keyword.length(); j++) //checks the keyword for the selected character
                			{
                				if(keyword.substring(j, j+1).equalsIgnoreCase(listOne[i])) //if keyword at j is equal to the selected character
                				{
                					checkTruth = true; // changes status to true
                					tempArray[j] = listOne[i]; // changes "_" to selected character
                					if (Character.isUpperCase(keyword.charAt(j)))// turns letter to uppercase if letter was 
                					{
                						tempArray[j] = listOne[i].toUpperCase(); // changes selected character to its uppercase
                					}
                				}
                			}
                			if (checkTruth == false) // if character is not in keyword, call resultChoice()
                			{
                				resultChoice();
                			}
                		keywordDisplay.setText("");// resets displat do
                		
                		winStatus = true;
                		for (int k = 0; k < keyword.length(); k++)//runs length of the keyword
                    	{
                    		keywordDisplay.appendText(tempArray[k]); //pritns out current
                    		if (!(keyword.substring(k, k+1).equals(tempArray[k])))//checks if word isn't complete
                    		{
                    			winStatus = false; // if word is not fully revelaled, does not allow vitory
                    		}
                    	}
                		if (winStatus == true)
                		{
                			strikes = 0; // sets strikes to zero
                			resultDisplay.appendText("\n\nYou won! Reset to play again!"); // prompts user to restart game
                		}
                	} 
                }
            }
            //end of checking for alphabet
        } // end of handle() method
    } // end ButtonHandler
}// end of GamePane