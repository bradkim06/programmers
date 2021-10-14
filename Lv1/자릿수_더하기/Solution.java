public class Solution {
    static final int modNum = 10;

    public int solution(int n) {
        int answer = 0;

        while (n != 0) {
            answer += n % modNum;
            n /= modNum;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(123));
    }
}
