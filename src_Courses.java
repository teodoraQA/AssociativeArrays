import java.io.StringBufferInputStream;
import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String course = tokens[0];
            String student = tokens[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);

            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((c1, c2) ->
                        (c2.getValue().size())- (c1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().stream().sorted(String::compareTo).
                            forEach(e -> System.out.printf("-- %s%n", e));
                });

    }
}
