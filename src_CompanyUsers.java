import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, List<String>> companies = new HashMap<>();

        while (!input.equals("End")){
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String employeeId = tokens[1];

            companies.putIfAbsent(company, new ArrayList<>());
            if(!companies.get(company).contains(employeeId)) {
                companies.get(company).add(employeeId);
            }
            input=scanner.nextLine();
        }

        companies.entrySet().stream()
                .sorted((c1,c2)-> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue().stream().forEach(id -> System.out.println("-- " + id));
                });
    }
}
