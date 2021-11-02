import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int x = 0, y = 0;
        int number = 1, number2 = n * n;
        int cnt = 0;

        while (cnt < n) {
            boolean stateY = isStateY(cnt);

            if (stateY) {
                y = cnt;
                x = 0;
            } else {
                y = 0;
                x = cnt;
            }

            for (int i = 0; i <= cnt; i++) {
                answer[x][y] = number++;
                answer[n - x - 1][n - y - 1] = number2--;

                if (stateY) {
                    y--;
                    x++;
                } else {
                    x--;
                    y++;
                }
            }

            cnt++;
        }

        return answer;
    }

    private boolean isStateY(int count) {
        if (count % 2 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] testArr = test.solution(5);

        for (int i = 0; i < testArr.length; i++) {
            System.out.println(Arrays.toString(testArr[i]));
        }
    }
}
