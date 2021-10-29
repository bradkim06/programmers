class Solution {
    public String solution(String cryptogram) {
        String answer = "";

        decoding(cryptogram);

        return answer;
    }

    private String decoding(String cryptogram) {
        String str = "";
        boolean findDup = false;

        for (int i = 0; i < cryptogram.length(); i++) {
            char currCh = cryptogram.charAt(i);

            if (i > 0) {
                char prevCh = cryptogram.charAt(i - 1);
                if (currCh == prevCh) {
                    findDup = true;
                    continue;
                }
            }

            if (i < cryptogram.length() - 1) {
                char nextCh = cryptogram.charAt(i + 1);
                if (currCh == nextCh) {
                    findDup = true;
                    continue;
                }
            }

            str += currCh;
        }

        if (findDup) {
            decoding(str);
        }

        return str;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("zyelleyz"));
    }
}
