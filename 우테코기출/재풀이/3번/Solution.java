import java.util.HashMap;

class Solution {
    static char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static char[] replace = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
            'n', 'g', 'f', 'e', 'd', 'c', 'b', 'a' };

    public String solution(String word) {
        String answer = "";

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            map.put(letters[i], replace[i]);
            map.put(Character.toUpperCase(letters[i]), Character.toUpperCase(replace[i]));
        }

        System.out.println(map);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                answer += map.get(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                answer += map.get(ch);
            } else {
                answer += ch;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("I love you"));
    }
}
