class Solution {
    public int solution(int[] pobi, int[] crong) {
        int answer = 0;
        int[] result = new int[2];

        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        result[0] = findBigNum(pobi);
        result[1] = findBigNum(crong);

        if (result[0] > result[1]) {
            answer = 1;
        } else if (result[1] > result[0]) {
            answer = 2;
        }

        return answer;
    }

    private boolean isException(int[] pages) {
        if (pages[0] == 1 || pages[1] == 400) {
            return true;
        }

        if (pages[0] != (pages[1] - 1)) {
            return true;
        }

        return false;
    }

    private int findBigNum(int[] pages) {
        int sum0 = 0, sum1 = 0;
        int mul0 = 1, mul1 = 1;

        while (pages[0] != 0) {
            int remains = pages[0] % 10;

            sum0 += remains;
            mul0 *= remains;
            pages[0] /= 10;
        }

        while (pages[1] != 0) {
            int remains = pages[1] % 10;

            sum1 += remains;
            mul1 *= remains;
            pages[1] /= 10;
        }

        int max0 = Math.max(sum0, mul0);
        int max1 = Math.max(sum1, mul1);

        return Math.max(max0, max1);
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] pobi = { 99, 102 };
        int[] crong = { 211, 212 };
        System.out.println(test.solution(pobi, crong));
    }
}
