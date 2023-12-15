package MonsterMatch;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

/**
 * @author: Thy Doan
 * 
 * Date: 12/08/2023
 * 
 * Class Responsibility: This class will creating the UI of the game
 * 
 */

public class MonsterMatchView extends JFrame
{
	//Fields
	JFrame frame;												//MonsterMatchView has-a frame
	JButton triesRemaining;										//MonsterMatchView has-a start button
	JButton resetButton;										//MonsterMatchView has-a reset button
	JLabel matchCountingLabel;									//MonsterMatchView has-a label to count how many matches
	JLabel leaderScore;											//MonsterMatchView has-a leader score
	JLabel authorLabel;											//MonsterMatchView has-an author label
	JPanel pokeBallPanel;										//MonsterMatchView has-a poke ball panel
	JPanel controlPanel;										//MonsterMatchView has-a control panel
	GameModel gameModel;										//MonsterMatchView has-a game model
	PokeBall[][] pokeBalls;
	Font myFont = new Font("Manrope", Font.PLAIN,20);			//MonsterMatchView has-a custom font
	ImageIcon ballImage;
	//Constructor
	public MonsterMatchView(GameModel model)
	{
		this.gameModel = model;									//Assign model to game model
		initializedUI();										//Call initializedUI to set up the frame
			
	}
	
	//Methods
	private void initializedUI()
	{
		//Set up the frame
		frame = new JFrame ("Monster Match");					//Create the frame with title "Monster Match"
		frame.setSize(1000,700); 								//Set size of frame to 1000x500
		frame.setResizable(false); 								//Set the frame to non-resizable
		frame.setLocationRelativeTo(null); 						//Make the frame appear in the middle of the monitor
		frame.setLayout(null); 									//Set the layout of frame to null
		
		//Set up and add pokeBall panel to frame
		pokeBallPanel = new JPanel();
		pokeBallPanel.setLayout(new GridLayout(4,4,10,10));
		ballImage = new ImageIcon(getClass().getResource("ball.png"));
		pokeBalls = new PokeBall[GameModel.DIMENSION][GameModel.DIMENSION];
		
		for (int i = 0; i < gameModel.DIMENSION; i++)
		{
			for (int j = 0; j < gameModel.DIMENSION; j++)
			{
				PokeBall button = new PokeBall(i,j);
				button.setIcon(ballImage);
				button.addActionListener(new PokeBallListener (button, gameModel, this));
				pokeBalls[i][j] = button;
 				pokeBallPanel.add(button);
			}
		}
		
		pokeBallPanel.setBounds(40,40,550,550);
		frame.add(pokeBallPanel);
		
		//Set up control panel
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(4,1,50,50));
		
		matchCountingLabel = new JLabel ();						//Create a label to count how many matches player have
		matchCountingLabel.setText("Matches: 0");
		matchCountingLabel.setFont(myFont);
		controlPanel.add(matchCountingLabel);					//control panel has-a label to update how many matches the player has
				
		triesRemaining = new JButton();							//Create a button to start the game
		triesRemaining.setText("Tries: " + gameModel.getNumbersOfTries());
		triesRemaining.setFont(myFont);
		triesRemaining.addActionListener(null);					//Add listener to start button
		controlPanel.add(triesRemaining);							//Add start button to control panel
		
		resetButton = new JButton();							//Create a reset button to reset the game
		resetButton.addActionListener(null);					//Add a listener to reset button
		resetButton.setFont(myFont);
		resetButton.setText("Reset");							//Set text so the label will appear as "Reset"
		controlPanel.add(resetButton);							//Add reset button to control panel
		
		leaderScore = new JLabel();								//Create a label for leader score
		leaderScore.setText("Leader Score");					//Set text so the label will appear as "Leader Score"
		
		controlPanel.setBounds(650,100,250,400);				//Set position for control panel
		frame.add(controlPanel);								//Add position panel to frame		
		
		//Set up and add author label to frame
		authorLabel = new JLabel("Programmed by: Thy Doan");	//Create an author label with title
		authorLabel.setBounds(250,320,600,600);					//set position for author label
		frame.add(authorLabel);									//Add author label to the game frame
		
		//Set the frame behavior (visibla and exit on close)
		frame.setVisible(true); 								//Set to true, so we can actually see the frame on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//This ensure that program will close when we click close program
	}
	
	//Update UI for Opening and Closing the PokeBalls
	public void updateUI()
	{
		matchCountingLabel.setText("Matches: " + gameModel.getPairsFound());
		triesRemaining.setText("Tries remaining: " + gameModel.getNumbersOfTries());

		if (gameModel.isGameOver())
		{
			for (int i = 0; i < gameModel.DIMENSION; i++)
			{
				for ( int j = 0; j < gameModel.DIMENSION; j++)
				{
					pokeBalls[i][j].setEnabled(false);
				}
			}
		}
		if (gameModel.isWin())
		{
			JOptionPane.showMessageDialog(frame, "You are the very best like no one ever was!!!!");
		}
		if (gameModel.isLost())
		{
			JOptionPane.showMessageDialog(frame, "You lose!");
		}


	}
}








