class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for (int num : arr) {
            answer += num;
        }

        answer /= arr.length;

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] testArr = { 1, 2, 3, 4 };
        System.out.println(test.solution(testArr));
    }
}
