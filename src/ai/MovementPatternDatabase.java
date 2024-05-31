package ai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MovementPatternDatabase {

    public static final String FILEPATH = "/Users/jaime/Documents/CS/Java/Projects/Chess/src/ai/games_modified.csv";

    public static void getData() {

    }

    private static List<String> loadData() {
        String line = "";
        List<String> moves = new LinkedList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILEPATH))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                moves.add(data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return moves;
    }

    private static List<int[]> parseMoves(String moves) {
        return null;
    }

    private static int positionToArray(String pos) {
        return 0;
    }
}