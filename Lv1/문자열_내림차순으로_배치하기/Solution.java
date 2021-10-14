import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] array = s.split("");
        Arrays.sort(array, Collections.reverseOrder());

        String answer = String.join("", array);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("Zbcdefg"));
    }
}
