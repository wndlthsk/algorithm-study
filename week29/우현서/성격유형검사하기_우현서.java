import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> score;

    public String solution(String[] survey, int[] choices) {
        score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);

        for (int i=0; i< survey.length; i++) {
            Character x = survey[i].charAt(0);
            Character y = survey[i].charAt(1);
            addScore(x, y, choices[i]);
        }
        // System.out.println(score);

        String[] types = {"RT", "CF", "JM", "AN"};
        StringBuilder result = new StringBuilder();

        for (String type: types) {
            Character x = type.charAt(0);
            Character y = type.charAt(1);

            int scoreX = score.get(x);
            int scoreY = score.get(y);
            // System.out.println("x: " + x + " y: " + y + " sx: " + scoreX + " sy: "+ scoreY);

            if (scoreX > scoreY) result.append(x);
            else if (scoreX < scoreY) result.append(y);
            else {
                if (x < y) result.append(x);
                else result.append(y);
            }
        }
        // System.out.println(result);

        return result.toString();
    }

    public void addScore(Character x, Character y, int choice) {
        if (choice < 4) {
            int curr = score.get(x);
            if (choice == 1) score.put(x, curr + 3);
            else if (choice == 2) score.put(x, curr + 2);
            else if (choice == 3) score.put(x, curr + 1);
        } else if (choice > 4) {
            int curr = score.get(y);
            if (choice == 5) score.put(y, curr + 1);
            else if (choice == 6) score.put(y, curr + 2);
            else if (choice == 7) score.put(y, curr + 3);
        }
    }
}