import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> products = new HashMap<>();
        LinkedHashMap<String,Integer> buyList = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){
            String[] tokens = input.split(" ");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int qty = Integer.parseInt(tokens[2]);

            products.put(product, price);
            buyList.putIfAbsent(product, 0);
            buyList.put(product, buyList.get(product) + qty);

            input= scanner.nextLine();
        }

        buyList.forEach((key, value) -> {
            String purchase = String.format("%s -> %.2f",
                    key, value * products.get(key));
            System.out.println(purchase);
        });
    }
}
