import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            if (Arrays.stream(board[i]).anyMatch(x -> x == 1)) {
                answer = 1;
                break;
            }
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int min = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1]));

                    board[i][j] = min + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        // System.out.println(Arrays.deepToString(board));

        return answer * answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

        System.out.println(test.solution(board));

        int[][] board2 = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };

        System.out.println(test.solution(board2));

        int[][] board3 = { { 0 }, { 1 } };

        System.out.println(test.solution(board3));
    }
}
