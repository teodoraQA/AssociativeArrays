import java.util.LinkedHashMap;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> registeredCars = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String username = input[1];

            if (command.equals("register")) {
                String idCar = input[2];

                if (registeredCars.containsKey(username)) {
                    System.out.printf("ERROR: already registered with plate number %s%n",
                            registeredCars.get(username));
                } else {
                    registeredCars.putIfAbsent(username, idCar);
                    System.out.printf("%s registered %s successfully%n",
                            username, registeredCars.get(username));
                }
            } else {
                if (registeredCars.containsKey(username)) {
                    System.out.printf("%s unregistered successfully%n", username);
                    registeredCars.remove(username);
                } else {
                    System.out.printf("ERROR: user %s not found%n", username);
                }
            }
        }

        registeredCars
                .forEach((k, v) ->{
                    String regUsers = String.format("%s => %s", k, v);
                    System.out.println(regUsers);
                });
    }
}

