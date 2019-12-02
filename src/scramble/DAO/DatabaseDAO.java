package scramble.DAO;

import java.io.File;

import scramble.WordScrambleGame;
import scramble.model.ScrambleModel;

public class DatabaseDAO {

	private static File wordsDatabase;

	//Singleton implementation of database?

	public DatabaseDAO(ScrambleModel scrambleModel) {
		switch (scrambleModel.getCurrentDifficulty()) {
		case EASY: {
			DatabaseDAO.wordsDatabase = new File("EasyWordDatabase.txt");
			break;
		}
		case MEDIUM: {
			DatabaseDAO.wordsDatabase = new File("MediumWordDatabase.txt");
			break;
		}
		case HARD: {
			DatabaseDAO.wordsDatabase = new File("HardWordDatabase.txt");
			break;
		}
		default: {
			DatabaseDAO.wordsDatabase = new File("EasyWordDatabase.txt");
			break;
		}
		}
	}

}
