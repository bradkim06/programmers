import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> waitQ = new LinkedList<>();
        Queue<Integer> bridgeQ = new LinkedList<>();

        for (int tWeight : truck_weights) {
            waitQ.add(tWeight);
        }

        int currWeight = 0;

        while (!waitQ.isEmpty() || currWeight != 0) {
            // System.out.println(answer + " " + bridgeQ + " " + currWeight);
            answer++;

            if (currWeight == 0) {
                int truck = waitQ.poll();
                currWeight += truck;
                bridgeQ.add(truck);
                continue;
            }

            if (bridgeQ.size() == bridge_length) {
                currWeight -= bridgeQ.poll();
            }

            if (!waitQ.isEmpty() && currWeight + waitQ.peek() <= weight) {
                int truck = waitQ.poll();
                currWeight += truck;
                bridgeQ.add(truck);
                continue;
            }

            bridgeQ.add(0);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        // int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        int[] truck_weights = { 7, 4, 5, 6 };

        System.out.println(test.solution(2, 10, truck_weights));
    }
}
