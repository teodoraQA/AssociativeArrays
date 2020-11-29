import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

      input = Arrays.stream(input)
              .filter(w-> w.length() %2 ==0)
              .toArray(String[]::new);

        for (String word: input) {
            System.out.println(word);
        }
    }
}
