import java.util.*;
import java.util.Map.Entry;

class Solution {
    public final int[] STUDENT1 = { 1, 2, 3, 4, 5 };
    public final int[] STUDENT2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
    public final int[] STUDENT3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public int[] solution(int[] answers) {
        int[][] student = { STUDENT1, STUDENT2, STUDENT3 };

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < student.length; j++) {
                int mark = student[j][i % student[j].length];

                if (mark == answers[i]) {
                    map.put(j + 1, map.getOrDefault(j + 1, 0) + 1);
                }
            }
        }
        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        int maxScore = 0;

        for (Entry<Integer, Integer> entry : list_entries) {
            if (list.isEmpty()) {
                maxScore = entry.getValue();
                list.add(entry.getKey());
            } else if (maxScore == entry.getValue()) {
                list.add(entry.getKey());
            } else {
                break;
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] answers = { 1, 1, 2, 3, 2 };
        System.out.println(Arrays.toString(test.solution(answers)));
    }
}
