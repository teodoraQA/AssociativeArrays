import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        nums.sort(Integer::compareTo);
        Collections.reverse(nums);

        if (nums.size() < 3){
            for (int n: nums) {
                System.out.print(n + " ");
            }
        } else
            for (int i = 0; i < 3 ; i++) {
                System.out.print(nums.get(i) + " ");
            }

    }
}
