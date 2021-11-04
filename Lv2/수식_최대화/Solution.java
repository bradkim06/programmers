import java.util.*;

class Solution {
    static final char[] opArr = { '-', '+', '*' };
    boolean[] visited = new boolean[3];
    ArrayList<Long> numList = new ArrayList<>();
    ArrayList<Character> opList = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {
        String number = "";

        for (char a : expression.toCharArray()) {
            if (a == '-' || a == '+' || a == '*') {
                numList.add(Long.parseLong(number));
                opList.add(a);
                number = "";
                continue;
            }
            number += a;
        }
        numList.add(Long.parseLong(number));

        dfs("");

        return answer;
    }

    private void dfs(String str) {
        if (str.length() == opArr.length) {
            answer = Math.max(answer, calc(str));
        }

        for (int i = 0; i < opArr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(str + opArr[i]);
            visited[i] = false;
        }
    }

    private long calc(String opStr) {
        ArrayList<Long> nums = (ArrayList<Long>) numList.clone();
        ArrayList<Character> ops = (ArrayList<Character>) opList.clone();
        long sumResult = 0;

        for (char operator : opStr.toCharArray()) {
            for (int i = 0; i < ops.size(); i++) {
                if (ops.get(i) == operator) {
                    long result = 0;

                    if (operator == '*') {
                        result += nums.get(i) * nums.get(i + 1);
                    } else if (operator == '+') {
                        result += nums.get(i) + nums.get(i + 1);
                    } else if (operator == '-') {
                        result += nums.get(i) - nums.get(i + 1);
                    } else {
                        continue;
                    }

                    nums.remove(i + 1);
                    nums.set(i, result);
                    ops.remove(i);
                    i--;
                }
            }
        }

        return Math.abs(nums.get(0));
    }

    public static void main(String... args) {
        Solution test = new Solution();

        // System.out.println(test.solution("100-200*300-500+20"));
        System.out.println(test.solution("50*6-3*2"));
    }
}
