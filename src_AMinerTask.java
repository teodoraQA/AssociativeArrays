import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.lang.*;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer>  resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String resource = input;
            int qty = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(resource, 0);
            int currentQty = resources.get(resource);
            resources.put(resource, currentQty + qty);

            input = scanner.nextLine();
        }

        resources.entrySet()
                .forEach(r -> {
                    String print = String.format("%s -> %d",r.getKey(), r.getValue());
                    System.out.println(print);
                });
    }
}
