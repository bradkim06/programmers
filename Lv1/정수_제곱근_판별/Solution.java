class Solution {
    public long solution(long n) {
        long answer = 0;

        double sqrt = Math.sqrt(n);
        long integer = (long) sqrt;

        if (sqrt - integer == 0) {
            answer = (integer + 1) * (integer + 1);
        } else {
            answer = -1;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(121));
    }
}
