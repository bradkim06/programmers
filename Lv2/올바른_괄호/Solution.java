class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cntOpen++;
            } else if (s.charAt(i) == ')') {
                if (cntOpen < 1) {
                    return false;
                }

                cntOpen--;
            }
        }

        if (cntOpen != 0) {
            return false;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("()()"));
        System.out.println(test.solution("(())()"));
        System.out.println(test.solution(")()("));
        System.out.println(test.solution("(()("));
    }
}
