class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (checkEvenDivisor(i) == true) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

    private boolean checkEvenDivisor(int num) {
        int countDivisor = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                countDivisor++;
                if (i * i != num) {
                    countDivisor++;
                }
            }
        }

        if (countDivisor % 2 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(13, 17));
    }
}
