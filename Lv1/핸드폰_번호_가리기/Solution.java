class Solution {
    public String solution(String phone_number) {
        String answer = "";

        int fullLen = phone_number.length();
        int starLen = fullLen - 4;

        for (int i = 0; i < starLen; i++) {
            answer += "*";
        }

        answer += phone_number.substring(starLen, fullLen);

        System.out.println(answer);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();
        test.solution("128322");
    }
}
