class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if (a == b) {
            return a;
        } else if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = a; i <= b; i++) {
            answer += i;
        }

        return answer;
    }

    public static void main(String... Args) {
        Solution test = new Solution();
        System.out.println(test.solution(5, 3));
    }
}
