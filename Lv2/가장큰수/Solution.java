import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (strNum[0].equals("0")) {
            answer = "0";
        } else {
            for (String str : strNum) {
                answer += str;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] numbers = { 6, 10, 2 };
        System.out.println(test.solution(numbers));
    }
}
