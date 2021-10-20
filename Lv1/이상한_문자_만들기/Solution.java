class Solution {
    static final int ofsLetterCase = 32;

    public String solution(String s) {
        String answer = "";
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (checkSpace(ch)) {
                cnt = 0;
                answer += ch;
                continue;
            }

            if (cnt % 2 == 0) {
                if (checkSmallCase(ch)) {
                    ch -= ofsLetterCase;
                }
            } else {
                if (!checkSmallCase(ch)) {
                    ch += ofsLetterCase;
                }
            }

            cnt++;
            answer += ch;
        }

        return answer;
    }

    private boolean checkSmallCase(char ch) {
        if (ch >= 'a') {
            return true;
        }

        return false;
    }

    private boolean checkSpace(char ch) {
        if (ch == ' ') {
            return true;
        }

        return false;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("try hello world"));
    }
}
