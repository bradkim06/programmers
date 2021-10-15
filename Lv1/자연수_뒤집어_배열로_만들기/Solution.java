import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static final int MOD = 10;

    public int[] solution(long n) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add((int) (n % MOD));
            n /= MOD;
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(12345)));
    }
}
