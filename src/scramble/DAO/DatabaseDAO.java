package scramble.DAO;

import java.io.File;

import scramble.WordScrambleGame;

public class DatabaseDAO {

	private static File wordsDatabase;

	//Singleton implementation of database?

	public DatabaseDAO() {
		switch (WordScrambleGame.getCurrentDifficulty()) {
		case EASY: {
			this.wordsDatabase = new File("EasyWordDatabase.txt");
			break;
		}
		case MEDIUM: {
			this.wordsDatabase = new File("MediumWordDatabase.txt");
			break;
		}
		case HARD: {
			this.wordsDatabase = new File("HardWordDatabase.txt");
			break;
		}
		default: {
			this.wordsDatabase = new File("EasyWordDatabase.txt");
			break;
		}
		}
	}

}
