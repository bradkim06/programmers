import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i : moves) {
            int index = i - 1;

            for (int j = 0; j < board.length; j++) {
                int doll = board[j][index];

                if (doll != 0) {
                    if (stack.isEmpty()) {
                        stack.push(doll);
                    } else {
                        if (stack.peek() == doll) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(doll);
                        }
                    }

                    board[j][index] = 0;

                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(test.solution(board, moves));
    }
}
