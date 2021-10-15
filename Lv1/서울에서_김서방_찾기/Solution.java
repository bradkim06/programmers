class Solution {
    static final String KIM = "Kim";

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals(KIM)) {
                answer += "김서방은 " + i + "에 있다";
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] testArr = { "Jane", "Kim" };
        System.out.println(test.solution(testArr));
    }
}
