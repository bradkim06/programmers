import java.util.Arrays;

class Solution {
    static final int[] MOD = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public int[] solution(int money) {
        int[] answer = new int[MOD.length];

        for (int i = 0; i < MOD.length; i++) {
            answer[i] = money / MOD[i];
            money = money % MOD[i];
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(15000)));
    }
}
