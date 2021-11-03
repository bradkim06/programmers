class Solution {
    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ");

        int max = Integer.parseInt(str[0]);
        int min = max;

        for (String number : str) {
            int num = Integer.parseInt(number);

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        answer += Integer.toString(min);
        answer += " ";
        answer += Integer.toString(max);

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("1 2 3 4"));
        System.out.println(test.solution("-1 -2 -3 -4"));
        System.out.println(test.solution("-1 -1"));
    }
}
