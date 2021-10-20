class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;

        for (int i = 1; i < count + 1; i++) {
            sum += price * i;
        }

        answer = sum - money;

        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(3, 20, 4));
    }
}
