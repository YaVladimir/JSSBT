import java.io.BufferedReader;
import java.util.*;

/**
 * Created by Yakovenko on 16.12.2017.
 */
public class SGU2056 {
    public static void main(String[] args) {
        //String input = "Sebastian Vettel is a German one Formula One racing driver currently driving for Red Bull Racing";
        String input = "a aa aaa aaaa\n" +
                "a aa aaa bbbb";
        //Scanner scanner = new Scanner();
        input = input.replaceAll("\\n", " ");
        String[] strings = input.split(" ");

        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                chars[j] = Character.toLowerCase(chars[j]);
            }
            strings[i] = new String(chars);
        }

        Map<String, Integer> words = new HashMap<>();
        int maxCount = 0;
        for (String s : strings) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
                if (words.get(s) > maxCount) {
                    maxCount = words.get(s);
                }
            } else {
                words.put(s, 1);
                if (maxCount == 0) {
                    maxCount += 1;
                }
            }
        }
        Set<String> setOfSelectWords = new TreeSet<>();
        for (String s : strings) {
            if (words.get(s) == maxCount) {
                setOfSelectWords.add(s);
            }
        }

        System.out.println(words);
        System.out.println(setOfSelectWords);

    }
}
