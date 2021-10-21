class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i] == false) {
                absolutes[i] *= -1;
            }

            answer += absolutes[i];
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] absolutes = { 4, 7, 12 };
        boolean[] signs = { true, false, true };
        System.out.println(test.solution(absolutes, signs));
    }
}
