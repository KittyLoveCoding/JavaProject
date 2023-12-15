package MonsterMatch;

import java.lang.reflect.Array;
import java.util.*;

import javax.swing.*;

/**
 * @author: Thy Doan
 * 
 * Date: 12/02/2023
 * 
 * Class Responsibility: This will be the game model.
 */


public class GameModel
{
	//Fields
	public static int DIMENSION = 4;
	private PokeBall[][] pokeBalls;											//GameModel has-a list of pokeBalls
	private PokeBall pickedOne;												//GameModel has-a selectedPokeBall to track which one is selected
	private PokeBall pickedTwo;
	private int pairsFound;													//GameModel track how many pairs founded
	private int numbersOfImages = 8;
	private int numbersOfTries = 10;
	//Constructor
	public GameModel()
	{
		pokeBalls = new PokeBall[DIMENSION][DIMENSION];										//Create an arrayList to holds the pokeBalls
		pairsFound = 0;														//Set pairs found to 0
		
		List<ImageIcon> images = new ArrayList<>();							//Create an arrayList to hold pokeBalls images
		for (int i = 0; i < numbersOfImages; i++)							
		{
			images.add(new ImageIcon(getClass().getResource(i + ".png")));	//Added 8 pictures of PokeBalls to the images array
			images.add(new ImageIcon(getClass().getResource(i + ".png")));	//Added 8 pictures of PokeBalls to the images array
		}
		
		int count = 0;
		for (int i = 0; i < DIMENSION; i++)							//Loops through the 8 images added
		{	
			for (int j = 0; j < DIMENSION; j++)
			{
				pokeBalls[i][j] = new PokeBall(i,j,images.get(count));
				count++;
			}
		}
//		shuffle(pokeBalls);										//Use method shuffle in Collection class to randomize these card everytime the game started
	}
	
	//Methods
	/**
	 * Method to get the total of balls 
	 * @return size of poke Ball array list
	 */
	public int getTotalNumbersOfPokeBall ()
	{
		return pokeBalls.length;
	}
	
	/**
	 * Method to return the select pokeBall
	 */
	public PokeBall selectPokeBallAt(int row, int column)
	{
		return pokeBalls[row][column];
	}
	
//	/**
//	 * Method to shuffle 2d array
//	 */
//	public static void shuffle(PokeBall[][] array)
//	{
//		//Make a 2d array into 1d array
//		int rows = array.length;
//		int columns = array[0].length;
//		PokeBall[] newArray = new PokeBall [];
//	}
	
	/**
	 * Method to set the first pick of pokeBall
	 */
	public void setPickedOne(PokeBall pickedOne)
	{
		this.pickedOne = pickedOne;
	}
	
	/**
	 * Method to get the selected pokeBall
	 * @return the selected pokaBall
	 */
	public PokeBall getPickedOne()
	{
		return pickedOne;
	}
	
	/**
	 * 
	 */
	public void setPickedTwo (PokeBall pickedTwo)
	{
		this.pickedTwo = pickedTwo;
	}
	
	/**
	 * 
	 */
	public PokeBall getPickedTwo()
	{
		return pickedTwo;
	}
	
	/**
	 * true if 2 balls matched, false if not
	 * also increase pairs found by one if matched
	 */
	public boolean compareMatchedOfTwoPokeBalls (PokeBall pickedOne, PokeBall pickedTwo) 
	{
		if (pokeBalls[pickedOne.getRow()][pickedOne.getColumn()].getImage().getDescription().equals(pokeBalls[pickedTwo.getRow()][pickedTwo.getColumn()].getImage().getDescription()))
		{
			pickedOne.setMatched(true);
			pickedTwo.setMatched(true);
			increasePairsFound();
			numbersOfTries--;
			return true;
		}	
		else
		{
			pickedOne.setMatched(false);
			pickedTwo.setMatched(false);
			numbersOfTries--;
			return false;
		}
	}
	
	/**
	 * Method to increase the pairs found
	 */
	public void increasePairsFound()
	{
		pairsFound++;
	}
	
	/**
	 * Method to get pairs founded
	 * @return number of pairs founded
	 */
	public int getPairsFound()
	{
		return pairsFound;
	}
	/**
	 * 
	 */
	public int getNumbersOfTries()
	{
		return numbersOfTries;
	}
	
	public boolean isWin()
	{
		return pairsFound == 8;
	}
	
	public boolean isLost()
	{
		return numbersOfTries == 0 && pairsFound < 8;
	}
	public boolean isGameOver()
	{
		return isWin() || isLost();
	}
}

















