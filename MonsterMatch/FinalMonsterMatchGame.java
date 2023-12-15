package MonsterMatch;
/**
 * @author: Thy Doan
 * 
 * Date: 12/10/2023
 * 
 * Class Responsibility: This FinalMonsterMatchGame will be the entry point for the program,
 * in which it will call the MonsterMatchView and pass in the game model
 * 
 */
public class FinalMonsterMatchGame
{

	//Main Method
	public static void main(String[] args)
	{
		GameModel model = new GameModel();
		MonsterMatchView view = new MonsterMatchView(model);		
	}
}
