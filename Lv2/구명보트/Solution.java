import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] visited = new boolean[people.length];

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        int next = people.length - 1;

        for (int i = 0; i < people.length; i++) {
            if (visited[i]) {
                break;
            }

            int sum = people[i] + people[next];

            if (sum > limit) {
                i--;
            }

            visited[next--] = true;

            answer++;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] people = { 50, 30, 20, 70, 10 };
        System.out.println(test.solution(people, 100));
    }
}
