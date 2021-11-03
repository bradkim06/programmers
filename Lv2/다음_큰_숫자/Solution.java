class Solution {
    public int solution(int n) {
        int answer = 0;
        int cntBinary = 0;

        int number = n;

        while (number > 0) {
            cntBinary += number % 2;
            number /= 2;
        }

        while (true) {
            n++;
            int cnt = 0;
            int num = n;

            while (num > 0) {
                cnt += num % 2;
                num /= 2;

                if (cnt > cntBinary) {
                    break;
                }
            }

            if (cnt == cntBinary) {
                answer = n;
                break;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(78));
        System.out.println(test.solution(15));
    }
}
