class Solution {
    public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String... Args) {
        Solution test = new Solution();

        System.out.println(test.solution("-1234"));
    }
}
