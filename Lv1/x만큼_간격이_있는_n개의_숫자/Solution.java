import java.util.Arrays;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long saveNum = 0;

        for (int i = 0; i < n; i++) {
            saveNum += x;
            answer[i] = saveNum;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(2, 5)));
    }
}
