package scramble.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

import scramble.WordScrambleGame;
import scramble.element.Score;
import scramble.element.User;
import scramble.model.ScrambleModel;

public class DatabaseDAO {

	private static File wordsDatabase;

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

	public ArrayList<String> retrieveScrambleList() throws IOException {
		try {
			ArrayList<String> scrambleList = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader(wordsDatabase));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				scrambleList.add(currentLine);
			}
			reader.close();
			Collections.shuffle(scrambleList);
			return scrambleList;
		} catch (IOException e) {
			throw new IOException("Error with files found");
		}
	}





}
