import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 2, 1, 3, 4, 1 };
        System.out.println(Arrays.toString(test.solution(testArr)));
    }
}
