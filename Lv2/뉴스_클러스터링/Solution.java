import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int count = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> list1 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);

            if (s.matches("[a-z]{2}")) {
                list1.add(s);
            }
        }

        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);

            if (s.matches("[a-z]{2}")) {
                list2.add(s);
            }
        }

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        for (String s : list1) {
            if (list2.remove(s)) {
                answer++;
            }
            count++;
        }

        count += list2.size();

        double j = (double) answer / (double) count;

        return (int) (j * 65536);
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("FRANCE", "french"));
        System.out.println(test.solution("handshake", "shake hands"));
        System.out.println(test.solution("aa1+aa2", "AAAA12"));
        System.out.println(test.solution("E=M*C^2", "e=m*c^2"));
    }
}
