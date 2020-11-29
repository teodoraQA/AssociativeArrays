import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> studentGrades = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double grade = Double.parseDouble(scanner.nextLine());

            studentGrades.putIfAbsent(name, new ArrayList<>());
            studentGrades.get(name).add(grade);
        }
        studentGrades.entrySet().stream()
                .filter(s -> s
                .getValue().stream()
                        .mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((s1,s2) ->{
                       double second= s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                       double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                       return Double.compare(second,first);
                })
                .forEach(s -> {
                    double avGrade = s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    System.out.println(String.format("%s -> %.2f",s.getKey(),avGrade));
                });
    }
}
