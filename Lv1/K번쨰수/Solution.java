import java.util.Arrays;

class Solution {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int ANSWER_INDEX = 2;
        
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][START_INDEX] - 1;
            int end = commands[i][END_INDEX];
            int answerIndex = commands[i][ANSWER_INDEX] - 1;
            
            
            int[] sliceArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(sliceArray);
            
            answer[i] = sliceArray[answerIndex];
        }
        
        return answer;
    }
}
