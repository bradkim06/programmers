class Solution {
    public String solution(int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            if ((i % 2) == 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(3));
    }
}
