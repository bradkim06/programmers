import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int cost : d) {
            budget -= cost;

            if (budget < 0) {
                break;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 1, 3, 2, 5, 4 };
        System.out.println(test.solution(testArr, 9));
    }
}
