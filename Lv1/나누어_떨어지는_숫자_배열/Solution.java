import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if ((i % divisor) == 0) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            list.add(-1);
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;

        // return Arrays.stream(arr).filter(element -> element % divisor ==
        // 0).toArray();
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 5, 9, 7, 10 };
        System.out.println(Arrays.toString(test.solution(testArr, 5)));
    }
}
