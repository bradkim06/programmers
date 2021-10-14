class Solution {
    static final String odd = "Odd";
    static final String even = "Even";

    public String solution(int num) {
        String answer = "";

        if((num % 2) == 0){
            answer = even;
        } else {
            answer = odd;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution(3));
    }
}
