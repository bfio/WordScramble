package scramble.DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scramble.element.Score;
import scramble.element.User;

public class ScoreDAO {

	private final static File scoresDatabase = new File("ScoresDatabase.txt");

	/**
	 * Writes a score to the final database for scores
	 * @param score Score to be written
	 * @throws IOException Thrown if scores database cannot be found
	 */
	public void writeScore(Score score) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(scoresDatabase, true));
		try {
			writer.write(score.getUser().toString() + "," + score.getPoints().toString());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in all the scores and user info from the scores database
	 * @return List of read in scores
	 * @throws IOException Thrown if scores database cannot be found
	 */
	public List<Score> readScores() throws IOException {
		ArrayList<Score> scoresArrayList = new ArrayList<Score>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(scoresDatabase));
			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				scoresArrayList.add(new Score(
						new User(currentLine.subSequence(0, currentLine.indexOf(',')).toString()), 
						Integer.valueOf(currentLine.substring(currentLine.indexOf(',') + 1)).intValue()));
			}
			reader.close();
		} catch (IOException e) {
			throw new IOException("Error with files found");
		}
		List<Score> scoresList = scoresArrayList.subList(0, scoresArrayList.size());
		Collections.sort(scoresList);
		return scoresList;
	}

}
