import javax.sound.midi.Soundbank;
import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> wordsSyn = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            wordsSyn.putIfAbsent(word, new ArrayList<>());
            wordsSyn.get(word).add(synonym);
        }

        wordsSyn.entrySet().stream()
                .forEach(w ->{
                    System.out.print(w.getKey() + " - ");
                    System.out.println(String.join(", ", w.getValue()));
                });
    }
}
