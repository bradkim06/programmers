class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int num : arr) {
            answer = getLCM(answer, num);
        }

        return answer;
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] arr = { 2, 6, 8, 14 };

        System.out.println(test.solution(arr));
    }
}
