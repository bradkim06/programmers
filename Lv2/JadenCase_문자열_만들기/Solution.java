class Solution {
    public String solution(String s) {
        String answer = "";
        boolean upperCase = true;

        String[] splitStr = s.toLowerCase().split("");

        for (int i = 0; i < splitStr.length; i++) {
            String str = splitStr[i];

            if (str.equals(" ")) {
                upperCase = true;
            } else {
                if (upperCase) {
                    str = str.toUpperCase();
                    upperCase = false;
                }
            }

            answer += str;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("3people unFollowed me"));
        System.out.println(test.solution("for the last week"));
        System.out.println(test.solution("for"));
        System.out.println(test.solution(" A  sdf fFt  t"));
    }
}
