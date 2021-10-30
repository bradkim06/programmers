class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            int cntNext = name.charAt(i) - 'A';
            int cntPrev = 'Z' - name.charAt(i) + 1;
            int minControl = Math.min(cntNext, cntPrev);

            answer += minControl;

            int next = i + 1;

            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i + len - next + i);
        }

        answer += move;

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("ABABAAAAAAABA"));
    }
}
