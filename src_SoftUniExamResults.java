import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, List<Integer>> usersPoint = new TreeMap<>();
        TreeMap<String, Integer> languageSubmissions = new TreeMap<>();

        while (!input.equals("exam finished")) {
            String[] tokens = input.split("-");
            String user = tokens[0];
            if (tokens.length == 3) {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

                usersPoint.putIfAbsent(user, new ArrayList<>());
                usersPoint.get(user).add(points);

                languageSubmissions.putIfAbsent(language, 0);
                int currentSubmissions = languageSubmissions.get(language);
                languageSubmissions.put(language, currentSubmissions + 1);
            } else {
                usersPoint.remove(user);
            }
            input = scanner.nextLine();
        }

//        print users max points
        System.out.println("Results:");
        printResults(usersPoint);

//        print language submissions
        System.out.println("Submissions:");
        printSubmissions(languageSubmissions);


    }

    private static void printSubmissions(TreeMap<String, Integer> languageSubmissions) {
        languageSubmissions.entrySet().stream()
                .sorted((l1, l2) -> {
                    int res = l2.getValue().compareTo(l1.getValue());
                    if (res == 0) {
                        res = l1.getKey().compareTo(l2.getKey());
                    }
                    return res;
                })
                .forEach(l -> System.out.println(String.format("%s - %d", l.getKey(), l.getValue())));
    }

    private static void printResults(TreeMap<String, List<Integer>> usersPoint) {
        usersPoint.entrySet().stream()
                .sorted((u1, u2) -> {
                    int u1MaxResult = u1.getValue().stream().mapToInt(Integer::intValue).max().getAsInt();
                    int u2MaxResult = u2.getValue().stream().mapToInt(Integer::intValue).max().getAsInt();
                    int res = Integer.compare(u2MaxResult, u1MaxResult);
                    if (res == 0) {
                        res = u1.getKey().compareTo(u2.getKey());
                    }
                    return res;
                })
                .forEach(u -> {
                    int maxPoints = u.getValue().stream().mapToInt(Integer::intValue).max().getAsInt();
                    System.out.println(String.format("%s | %d", u.getKey(), maxPoints));
                });
    }
}
