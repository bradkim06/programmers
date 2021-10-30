import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.add(date);
            System.out.println(q);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };
        // int[] progresses = { 95, 90, 99, 99, 80, 99 };
        // int[] speeds = { 1, 1, 1, 1, 1, 1 };

        System.out.println(Arrays.toString(test.solution(progresses, speeds)));
    }
}
