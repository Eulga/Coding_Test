package test;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        Arrays.stream(solution(new int[] {2,1,3,4,1})).forEach(System.out::println);
    }

    public static int[] solution(int []numbers) {
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int k = i + 1; k < numbers.length; k++) {
                numberSet.add(numbers[i] + numbers[k]);
            }
        }

        return numberSet.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
