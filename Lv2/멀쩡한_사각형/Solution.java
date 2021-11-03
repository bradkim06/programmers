class Solution {
    public long solution(int w, int h) {
        long answer = 0;

        double max = (double) Math.max(w, h);
        double min = (double) Math.min(w, h);
        long sum = 0;

        for (double j = 0; j < min; j++) {
            sum += Math.floor(max * j / min);
        }

        answer = sum + sum;

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(3, 3));
        System.out.println(test.solution(8, 12));
    }
}
