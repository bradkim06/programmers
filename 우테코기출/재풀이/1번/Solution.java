import java.util.Arrays;

class Solution {
    static final int[] MOD_MONEY = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    public int[] solution(int money) {
        int[] answer = new int[MOD_MONEY.length];

        for (int i = 0; i < MOD_MONEY.length; i++) {
            answer[i] = money / MOD_MONEY[i];
            money = money % MOD_MONEY[i];
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(50237)));
        System.out.println(Arrays.toString(test.solution(15000)));
    }
}
