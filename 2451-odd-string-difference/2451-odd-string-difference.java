import java.util.*;

public class Solution {

    static String getDifference(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            sb.append(str.charAt(i) - str.charAt(i - 1)).append(",");
        }

        return sb.toString();
    }

    public static String oddString(String[] words) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String diff = getDifference(word);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }

        for (String word : words) {
            String diff = getDifference(word);
            if (map.get(diff) == 1) {
                return word;
            }
        }

        return "";
    }
}