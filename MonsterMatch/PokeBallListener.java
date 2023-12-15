package MonsterMatch;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

/**
 * @author: Thy Doan
 * 
 * Date: 12/09/2023
 * 
 * Class Responsibility: PokeBallListener class will control the interaction between the PokeBall class
 * and the GameModel class. It will listen to when the pokeBall is clicked and perform the actions according to 
 * certain conditions.
 * 
 */
public class PokeBallListener implements ActionListener
{
	// Fields
	private PokeBall pokeBall;										//PokeBallListener has-a pokeBall
	private GameModel gameModel;									//PokeBallListener has-a game model
	private MonsterMatchView gameView;								//PokeBallListener has-a game view
	
	//Constructor
	public PokeBallListener (PokeBall pokeBall, GameModel gameModel, MonsterMatchView gameView)
	{
		this.pokeBall = pokeBall;									//Assign the pokeBall to this pokeBall
		this.gameModel = gameModel;									//Assign gameModel to this gameModel
		this.gameView = gameView;									//Assign gameView to this gameView
	}
	
	//Methods
	@Override	
	public void actionPerformed(ActionEvent e)
	{
		if (!pokeBall.isOpened() && gameModel.getPickedOne() == null)
		{
			pokeBall.setOpened(true);
			pokeBall.setIcon(gameModel.selectPokeBallAt(pokeBall.getRow(),pokeBall.getColumn()).getImage());
			gameModel.setPickedOne(gameModel.selectPokeBallAt(pokeBall.getRow(),pokeBall.getColumn()));
		}
		else if (!pokeBall.isOpened() && gameModel.getPickedOne() != null)
		{
			pokeBall.setOpened(true);
			pokeBall.setIcon(gameModel.selectPokeBallAt(pokeBall.getRow(), pokeBall.getColumn()).getImage());
			gameModel.setPickedTwo(gameModel.selectPokeBallAt(pokeBall.getRow(), pokeBall.getColumn()));
			//Compare 2 PokeBalls
			if (gameModel.compareMatchedOfTwoPokeBalls(gameModel.getPickedOne(), gameModel.getPickedTwo()))
			{
				gameView.pokeBalls[gameModel.getPickedOne().getRow()][gameModel.getPickedOne().getColumn()].setEnabled(false);
				gameView.pokeBalls[gameModel.getPickedTwo().getRow()][gameModel.getPickedTwo().getColumn()].setEnabled(false);
			}
			else
			{
				Timer delayTimer = new Timer();
				delayTimer.schedule(new TimerTask()
				{
					public void run()
					{
						SwingUtilities.invokeLater(() -> 
						{
							gameView.pokeBalls[gameModel.getPickedOne().getRow()][gameModel.getPickedOne().getColumn()].setIcon(gameView.ballImage);
							gameView.pokeBalls[gameModel.getPickedTwo().getRow()][gameModel.getPickedTwo().getColumn()].setIcon(gameView.ballImage);
							gameView.pokeBalls[gameModel.getPickedOne().getRow()][gameModel.getPickedOne().getColumn()].setOpened(false);
							pokeBall.setOpened(false);
							gameModel.setPickedOne(null);
							gameModel.setPickedTwo(null);
						});
					}
				}
				, 500);
				
				
			}

		}
		
		//After checking all the conditions, update the UI from game view
		gameView.updateUI();
	}
}
