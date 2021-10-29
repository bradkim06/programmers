class Solution {
    public int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int num = i;

            while (num != 0) {
                int remains = num % 10;

                if (remains != 0 && remains % 3 == 0) {
                    answer++;
                }

                num /= 10;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(33));
    }
}
