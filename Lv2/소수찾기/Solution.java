import java.util.*;

class Solution {
    boolean[] visited;
    HashSet<Integer> hashSet;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        hashSet = new HashSet<>();

        char[] arr = numbers.toCharArray();
        dfs(arr, "", 0);

        for (int num : hashSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(char[] numbers, String number, int count) {
        if (!number.isEmpty()) {
            hashSet.add(Integer.parseInt(number));
        }

        if (count == numbers.length) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(numbers, number + numbers[i], count + 1);
            visited[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        if (n % 2 == 0) {
            return n == 2 ? true : false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("17"));
    }
}
