class Solution {
    public String solution(String s) {
        String answer = "";

        int mid = s.length() / 2;

        if ((s.length() % 2) == 0) {
            answer += s.charAt(mid - 1);
        }

        answer += s.charAt(mid);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String testString = "abcde";
        System.out.println(test.solution(testString));
    }
}
