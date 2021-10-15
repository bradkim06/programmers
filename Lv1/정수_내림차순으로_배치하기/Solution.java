import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String[] arrNum = String.valueOf(n).split("");

        Arrays.sort(arrNum, Collections.reverseOrder());
        String strNum = String.join("", arrNum);

        answer = Long.parseLong(strNum);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(118372));
    }
}
