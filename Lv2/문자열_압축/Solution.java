class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String crypString = "";

            for (int j = 0; j < s.length();) {
                String str = "";
                int next = j + i;
                int count = 1;

                if (next > s.length()) {
                    next = s.length();
                }

                str = s.substring(j, next);

                while (next < s.length()) {
                    if (next + i > s.length()) {
                        break;
                    }

                    if (str.equals(s.substring(next, next + i))) {
                        count++;
                    } else {
                        break;
                    }

                    next = next + i;
                }

                if (count > 1) {
                    crypString += count + str;
                } else {
                    crypString += str;
                }

                j = j + i * count;

                // System.out.printf("str : %s cryp : %s\n", str, crypString);
            }
            answer = Math.min(answer, crypString.length());
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("aabbaccc"));
        // System.out.println(test.solution("xababcdcdababcdcd"));
    }
}
