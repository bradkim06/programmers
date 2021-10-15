import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length < 2) {
            return new int[] { -1 };
        }

        int[] answer = new int[arr.length - 1];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]) {
                continue;
            } else {
                answer[j++] = arr[i];
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(test.solution(testArr)));
    }
}
