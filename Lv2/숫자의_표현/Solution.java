class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            while (sum < n) {
                sum += num++;
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(15));
    }
}
