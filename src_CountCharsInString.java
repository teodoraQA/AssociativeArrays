import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.*;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> chars = new LinkedHashMap<>();

        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char ch = input.charAt(i);
            if(ch != ' '){
                chars.putIfAbsent(ch, 0);
                chars.put(ch, chars.get(ch) + 1);
            }
        }
        chars.entrySet()
                .forEach(c -> {
                    String print = String.format("%c -> %d", c.getKey(), c.getValue());
                    System.out.println(print);
                });
    }
}
