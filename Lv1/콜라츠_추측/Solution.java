class Solution {
    public int solution(long num) {
        int answer = 0;

        while (num != 1) {
            answer++;

            if (answer >= 500) {
                answer = -1;
                break;
            }

            if (num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num++;
            }

        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(626331));
    }
}
