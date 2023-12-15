package MonsterMatch;

/**
 * @author: Thy Doan
 * 
 * Date: 12/02/2023
 * 
 * Class Responsibility: This class will represent player, which will has name and score fo player
 * 
 */
public class Player
{
	//Fields
	private String name;
	private int score;
	
	//Constructor to assign name and score of a player
	public Player(String name, int score)
	{
		this.name = name;
		this.score = score;
	}
	
	//Methods
	/**
	 * Method to get name of player
	 * @return name of player
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Method to get score of player
	 * @return score of player
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Method to increase the score by one
	 */
	public void incrementScore()
	{
		score++;
	}
	
	/**
	 * Method to reset score to 0
	 */
	public void resetScore()
	{
		score = 0;
	}
}




