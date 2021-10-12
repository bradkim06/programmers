class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return true;
        }

        if (n % 2 == 0) {
            return n == 2 ? true : false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... Args) {
        Solution test = new Solution();
        test.solution(20);
    }
}
