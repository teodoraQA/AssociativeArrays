import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> legendary = new HashMap<>() {{
            put("shards", 0);
            put("motes", 0);
            put("fragments", 0);
        }};
        HashMap<String, String> legendaries = new HashMap<>() {{
            put("shards", "Shadowmourne");
            put("fragments", "Valanyr");
            put("motes", "Dragonwrath");
        }};
        HashMap<String, Integer> junks = new HashMap<>();
        boolean isObtained = false;

        while (!isObtained) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int qty = Integer.parseInt(input[i]);
                String resource = input[i + 1].toLowerCase();

                if (legendary.containsKey(resource)) {
                    legendary.put(resource, legendary.get(resource) + qty);
                    if (legendary.get(resource) >= 250) {
                        legendary.put(resource, legendary.get(resource) - 250);
                        isObtained = true;
                        System.out.println(String.format("%s obtained!", legendaries.get(resource)));
                        break;
                    }
                } else {
                    junks.putIfAbsent(resource, 0);
                    junks.put(resource, junks.get(resource) + qty);
                }
            }
        }
        legendary.entrySet().stream()
                .sorted((l1, l2) -> {
                    int result = l2.getValue().compareTo(l1.getValue());
                    if (result == 0) {
                        result = l1.getKey().compareTo(l2.getKey());
                    }
                    return result;
                })
                .forEach(l -> System.out.println(l.getKey() + ": " + l.getValue()));

        junks.entrySet().stream()
                .sorted((j1, j2) -> j1.getKey().compareTo(j2.getKey()))
                .forEach(j -> System.out.println(j.getKey() + ": " + j.getValue()));
    }
}
