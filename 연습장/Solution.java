import java.util.*;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        Arrays.sort(v, (o1, o2) -> o1[0] - o2[0]);

        int x = 0, y = 0;

        for (int i = 0; i < v.length - 1; i++) {
            x = Math.max(x, Math.abs(v[i][0] - v[i + 1][0]));
            y = Math.max(y, Math.abs(v[i][1] - v[i + 1][1]));
        }

        int[] dx = { x, 0, x };
        int[] dy = { 0, y, y };

        for (int i = 0; i < 3; i++) {
            answer[0] = v[0][0] + dx[i];
            answer[1] = v[0][1] + dy[i];

            for (int j = 1; j < v.length; j++) {
                if (answer[0] != v[j][0] && answer[1] != v[j][1]) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] v = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
        int[][] v2 = { { 1, 1 }, { 2, 2 }, { 1, 2 } };

        System.out.println(Arrays.toString(test.solution(v)));
        System.out.println(Arrays.toString(test.solution(v2)));
    }
}
