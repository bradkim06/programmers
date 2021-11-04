import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("baabaa"));
        System.out.println(test.solution("cdcd"));
    }
}
