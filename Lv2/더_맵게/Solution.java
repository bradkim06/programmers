import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int number : scoville) {
            heap.add(number);
        }

        // System.out.println(heap);

        while (heap.size() > 1 && heap.peek() < K) {
            int mixScoville = heap.poll() + (heap.poll() * 2);
            heap.add(mixScoville);
            answer++;
        }

        if (!heap.isEmpty() && heap.peek() < K) {
            return -1;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] scoville = { 1, 2, 3, 9, 10, 12 };

        System.out.println(test.solution(scoville, 7));
    }
}
