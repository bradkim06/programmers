class Solution {
    public int solution(int n) {
        int answer = 0;
        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            answer = a + b;
            if (answer > 1234567) {
                answer %= 1234567;
            }
            a = b;
            b = answer;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(5));
    }
}
