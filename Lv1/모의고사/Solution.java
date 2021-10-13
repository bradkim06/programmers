import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    static final int STUDENT1 = 0;
    static final int STUDENT2 = 1;
    static final int STUDENT3 = 2;

    public int[] solution(int[] answers) {

        int[][] student = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
        int[] score = { 0, 0, 0 };

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < student.length; j++) {
                if (answers[i] == student[j][i % student[j].length]) {
                    score[j]++;
                }
            }
        }

        int[] scoreSort = score.clone();
        Arrays.sort(scoreSort);

        int maxScore = scoreSort[2];
        ArrayList<Integer> topScoreList = new ArrayList<Integer>();

        for (int i = 0; i < student.length; i++) {
            if (score[i] == maxScore) {
                topScoreList.add(i + 1);
            }
        }

        int[] answer = new int[topScoreList.size()];

        for (int i = 0; i < topScoreList.size(); i++) {
            answer[i] = topScoreList.get(i);
        }

        return answer;
    }

    public static void main(String... Args) {
        Solution test = new Solution();

        int[] testArr = { 1, 2, 3, 4, 5 };
        int[] answer = test.solution(testArr);
        System.out.println(Arrays.toString(answer));
    }
}
