package main;

import java.util.ArrayList;

public class HighScore {
    private static ArrayList<Integer> allResults = new ArrayList<>();


    public static void addResult(int currentScore) {
        allResults.add(currentScore);
    }

    public static int getHighScore() {
        if (allResults.isEmpty()) {
            return 0;
        }
        allResults.sort((x, y) -> Integer.compare(y, x));

        return allResults.get(0);
    }
}
