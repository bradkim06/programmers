import java.util.Arrays;

class Solution {
    boolean[][] visited;
    int max;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[picture.length][picture[0].length];

        // for (int i = 0; i < picture.length; i++) {
        // System.out.println(Arrays.toString(picture[i]));
        // }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }

                if (picture[i][j] != 0) {
                    max = 0;

                    dfs(picture, i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int[][] picture, int i, int j) {
        if (visited[i][j]) {
            return;
        }

        max++;
        // System.out.printf("arr[%d][%d] = %d, count : %d\n", i, j, picture[i][j],
        // max);

        visited[i][j] = true;

        if (i < picture.length - 1 && picture[i][j] == picture[i + 1][j]) {
            dfs(picture, i + 1, j);
        }
        if (i > 0 && picture[i][j] == picture[i - 1][j]) {
            dfs(picture, i - 1, j);
        }
        if (j < picture[0].length - 1 && picture[i][j] == picture[i][j + 1]) {
            dfs(picture, i, j + 1);
        }
        if (j > 0 && picture[i][j] == picture[i][j - 1]) {
            dfs(picture, i, j - 1);
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };

        System.out.println(Arrays.toString(test.solution(6, 4, picture)));
    }
}
