import java.util.*;

class Solution {
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] str = places[i];
            answer[i] = 1;

            boolean fail = false;
            for (int x = 0; x < str.length; x++) {
                if (fail) {
                    break;
                }

                for (int y = 0; y < str[x].length(); y++) {
                    if (str[x].charAt(y) == 'P') {
                        if (bfs(str, x, y)) {
                            fail = true;
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

    static public boolean bfs(String[] str, int x1, int y1) {
        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { x1, y1 });
        boolean[][] visit = new boolean[5][5];
        visit[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dr[i];
                int ny = curr[1] + dc[i];

                if (nx < 0 || ny < 0) {
                    continue;
                }

                if (nx >= str.length || ny >= str[0].length()) {
                    continue;
                }

                if (visit[nx][ny]) {
                    continue;
                }

                visit[nx][ny] = true;
                int distance = Math.abs(nx - x1) + Math.abs(ny - y1);
                char ch = str[nx].charAt(ny);

                if (ch == 'X' || distance > 2) {
                    continue;
                }

                if (ch == 'P') {
                    return true;
                } else if (ch == 'O') {
                    queue.add(new int[] { nx, ny });
                }
            }
        }

        return false;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        for (int i = 0; i < places.length; i++) {
            System.out.println(Arrays.toString(places[i]));
        }

        System.out.println(Arrays.toString(test.solution(places)));
    }
}
