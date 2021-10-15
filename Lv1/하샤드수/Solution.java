class Solution {
    static final int MOD = 10;

    public boolean solution(int x) {
        boolean answer = true;

        int modSum = 0;
        int tempNum = x;

        while (tempNum != 0) {
            modSum += tempNum % MOD;
            tempNum /= MOD;
        }

        if ((x % modSum) != 0) {
            answer = false;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(11));
    }
}
