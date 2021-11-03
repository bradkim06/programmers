class Solution {
    public String solution(int n) {
        String answer = "";
        String[] change = { "4", "1", "2" };

        while (n > 0) {
            answer = change[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(1));
        System.out.println(test.solution(2));
        System.out.println(test.solution(3));
        System.out.println(test.solution(4));
    }
}
