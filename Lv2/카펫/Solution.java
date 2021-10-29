import java.util.*;

class Solution {
    ArrayList<Integer> list;
    boolean[] visited;
    int[] answer;
    int[] num;

    public int[] solution(int brown, int yellow) {
        answer = new int[2];
        int n = brown + yellow;
        list = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }

        visited = new boolean[list.size()];

        num = new int[2];
        dfs(list, 0, brown, yellow);

        return answer;
    }

    private void dfs(ArrayList<Integer> numbers, int count, int brown, int yellow) {
        if (count == 2) {
            if (num[0] >= num[1]) {
                if (brown == (num[0] * 2 + num[1] * 2 - 4)) {
                    if (yellow == num[0] * num[1] - brown) {
                        answer = num.clone();
                    }
                }
            }
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            num[count] = numbers.get(i);
            dfs(numbers, count + 1, brown, yellow);
        }
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution(10, 2)));
    }
}
