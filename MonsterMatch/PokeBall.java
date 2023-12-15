package MonsterMatch;

/**
 * @author Thy Doan
 * 
 * Date: 11/16/2023
 * 
 * Class Responsibility: This class will represent a ball which could be opened or closed
 */
public class PokeBall {
	//Fields
	//private int id;						//PokeBall has-an ID. Maybe I don't need this
	private int row;						//PokeBall has-a row
	private int column;						//PokeBall has-a column
	private boolean isOpened = false;		//PokeBall has-a status checking if the ball if opened or closed
	
	//Instructor setting the ball with a row and a column number
	PokeBall(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	/**
	 * Method to get the row of PokeBall
	 * @return the row position of the PokeBall
	 */
	public int getRow()
	{
		return row;
	}
	
	/**
	 * Method to get the column of PokeBall
	 * @return the column position of the PokeBall
	 */
	public int getColumn()
	{
		return column;
	}
	
	/**
	 * Method to set row for PokeBall
	 * @param row
	 */
	public void setRow(int row)
	{
		this.row = row;
	}
	
	/**
	 * Method to set column for PokeBall
	 * @param column
	 */
	public void setColumn(int column)
	{
		this.column = column;
	}

	/**
	 * Method to open PokeBall
	 */
	public void openPokeBall()
	{
		isOpened = true;
	}
	
	/**
	 * Method to close PokeBall
	 */
	public void closePokeBall()
	{
		isOpened = false;
	}
}
