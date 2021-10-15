import java.util.Arrays;

class Solution {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(2, 5)));
    }
}
