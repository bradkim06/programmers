import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<Integer>();

        int prevNum = 10;

        for (Integer num : arr) {
            if (prevNum != num) {
                list.add(num);
                prevNum = num;
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 1, 1, 3, 3, 0, 1, 1 };
        System.out.println(Arrays.toString(test.solution(testArr)));
    }
}
