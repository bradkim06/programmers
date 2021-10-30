import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        // System.out.println(Arrays.deepToString(routes));

        int number = -30000;

        for (int i = 0; i < routes.length; i++) {
            if (number < routes[i][0]) {
                number = routes[i][1];
                answer++;
                // System.out.println(number + " " + answer);
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };

        System.out.println(test.solution(routes));
    }
}
