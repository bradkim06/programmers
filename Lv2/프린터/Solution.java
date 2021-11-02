import java.util.*;

class Solution {
    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }

        Arrays.sort(priorities);

        int prioIndex = priorities.length - 1;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (curr.value >= priorities[prioIndex]) {
                answer++;
                prioIndex--;

                if (curr.index == location) {
                    break;
                }
            } else {
                queue.add(curr);
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] priorities = { 2, 1, 3, 2 };
        // int[] priorities = { 1, 1, 9, 1, 1, 1 };
        // int[] priorities = { 5, 2, 6, 1, 8, 5 };

        System.out.println(test.solution(priorities, 1));
    }
}
