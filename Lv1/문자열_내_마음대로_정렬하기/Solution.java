import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;

        String[] answer = new String[len];
        String[] sortArr = new String[len];

        for (int i = 0; i < len; i++) {
            sortArr[i] = strings[i].charAt(n) + strings[i];
        }

        Arrays.sort(sortArr);

        int index = 0;

        for (String s : sortArr) {
            answer[index++] = s.substring(1, s.length());
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] testArr = { "abce", "abcd", "cdx" };
        System.out.println(Arrays.toString(test.solution(testArr, 2)));
    }
}
