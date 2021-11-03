import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // System.out.println(Arrays.toString(A));
        // System.out.println(Arrays.toString(arr));

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };

        System.out.println(test.solution(A, B));
    }
}
