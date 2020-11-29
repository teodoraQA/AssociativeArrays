import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> nums = new TreeMap<Double, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            double n = numbers[i];
            nums.putIfAbsent(n, 0);
            int countN = nums.get(n);
            nums.put(n, countN + 1);
        }

        nums.entrySet()
                .forEach(n -> {
                    String result = String.format("%.0f -> %d", n.getKey(), n.getValue());
                    System.out.println(result);
                });
    }
}
