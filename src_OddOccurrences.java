import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().toLowerCase().split("\\s+");
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();

        for (String i: input) {
            words.putIfAbsent(i, 0);
            words.put(i, words.get(i) + 1);
        }

        List<String> oddOccurrences = new ArrayList<>();

        words.entrySet().stream()
                .filter(w-> w.getValue() %2 != 0)
                .forEach(w -> oddOccurrences.add(w.getKey()));

        System.out.println(String.join(", ", oddOccurrences));
    }
}
