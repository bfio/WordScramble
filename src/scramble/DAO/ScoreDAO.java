package scramble.DAO;

import java.io.File;
import java.util.ArrayList;

import scramble.element.Score;

public class ScoreDAO {
	
	private static ArrayList<Score> scores; 
	private final static File scoresDatabase = new File("ScoresDatabase.txt");
	
	public ScoreDAO() {
		
	}

}
