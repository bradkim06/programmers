import java.util.*;

class Solution {
    ArrayList<int[]> list = new ArrayList<>();

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 1; i < board.length; i++) {
                for (int j = 1; j < board[0].length(); j++) {
                    char ch = board[i].charAt(j);

                    if (ch != 'X' && check(board, i, j, ch)) {
                        changed = true;
                        // System.out.printf("board[%d][%d] find\n", i, j);
                    }
                }
            }

            for (int[] arr : list) {
                // System.out.println(Arrays.toString(arr));

                if (board[arr[0]].charAt(arr[1]) == 'X') {
                    continue;
                }

                StringBuilder sb = new StringBuilder(board[arr[0]]);
                sb.setCharAt(arr[1], 'X');
                board[arr[0]] = sb.toString();
                answer++;
            }

            list.clear();

            for (int i = 1; i < board.length; i++) {
                for (int j = 0; j < board[0].length(); j++) {
                    if (board[i].charAt(j) == 'X' && board[i - 1].charAt(j) != 'X') {

                        for (int index = i; index > 0; index--) {
                            StringBuilder sb = new StringBuilder(board[index]);
                            StringBuilder sb2 = new StringBuilder(board[index - 1]);

                            sb.setCharAt(j, board[index - 1].charAt(j));
                            board[index] = sb.toString();

                            sb2.setCharAt(j, 'X');
                            board[index - 1] = sb2.toString();
                        }
                    }
                }
            }

            // System.out.println(answer);
            // for (int i = 0; i < board.length; i++) {
            // System.out.println(board[i]);
            // }
        }

        return answer;
    }

    public boolean check(String[] board, int x, int y, char friends) {
        int[] dx = { -1, 0, -1, 0 };
        int[] dy = { -1, -1, 0, 0 };

        for (int i = 0; i < 3; i++) {
            char ch = board[x + dx[i]].charAt(y + dy[i]);
            // System.out.printf(" board[%d][%d] : %c\n", x - dx[i], y - dy[i], ch);

            if (ch != friends) {
                return false;
            }
        }

        for (int i = 0; i < 4; i++) {
            // System.out.printf("arr[%d][%d] list add\n", x + dx[i], y + dy[i]);
            list.add(new int[] { x + dx[i], y + dy[i] });
        }

        return true;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }

        System.out.println(test.solution(4, 5, board));
    }
}
