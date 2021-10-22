import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] countFailUser = new int[N];

        Map<Integer, Float> map = new HashMap<>();

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) {
                continue;
            }
            countFailUser[stages[i] - 1]++;
        }

        int numStageUser = stages.length;
        for (int i = 0; i < N; i++) {
            if (numStageUser == 0) {
                map.put(i, 0f);
                continue;
            }

            System.out.printf("countUser : %d Total : %d\n", countFailUser[i], numStageUser);
            map.put(i, (float) countFailUser[i] / (float) numStageUser);
            numStageUser -= countFailUser[i];
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());

        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int index = 0;
        for (Integer key : keySetList) {
            answer[index++] = key + 1;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
        System.out.println(Arrays.toString(test.solution(5, stages)));
    }
}
