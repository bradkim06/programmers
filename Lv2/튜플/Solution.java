import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        // System.out.println(s);

        char[] str = s.toCharArray();
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> nList = new ArrayList<>();

        int num = 0;

        for (char ch : str) {

            if (ch == '}') {
                if (num > 0) {
                    nList.add(num);
                    int[] arr = new int[nList.size()];

                    for (int i = 0; i < nList.size(); i++) {
                        arr[i] = nList.get(i);
                    }

                    list.add(arr);

                    nList.clear();
                    num = 0;
                }
            } else if (ch >= '0' && ch <= '9') {
                num *= 10;
                num += ch - '0';
            } else if (ch == ',') {
                if (num > 0) {
                    nList.add(num);
                    num = 0;
                }
            }
        }

        Collections.sort(list, (o1, o2) -> o1.length - o2.length);
        for (int[] arr : list) {
            for (int n : arr) {
                if (!nList.contains(n)) {
                    nList.add(n);
                }
            }
        }

        answer = new int[nList.size()];
        for (int i = 0; i < nList.size(); i++) {
            answer[i] = nList.get(i);
        }

        // for (int i = 0; i < list.size(); i++) {
        // }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(Arrays.toString(test.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
