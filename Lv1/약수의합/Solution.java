import java.util.HashSet;

class Solution {
    public int solution(int n) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; (i * i) <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }

        for (int i : set) {
            answer += i;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(12));
    }
}
