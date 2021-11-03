import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    final String ENTER_MSG = "님이 들어왔습니다.";
    final String LEAVE_MSG = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        String[] answer = {};

        String[][] splitStr = new String[record.length][3];

        for (int i = 0; i < record.length; i++) {
            splitStr[i] = record[i].split(" ");
        }

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < splitStr.length; i++) {
            String type = splitStr[i][0];

            if (type.equals("Leave")) {
                continue;
            }

            String uid = splitStr[i][1];
            String name = splitStr[i][2];

            if (type.equals("Enter")) {
                map.put(uid, name);
            } else if (type.equals("Change")) {
                map.put(uid, name);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < splitStr.length; i++) {
            String type = splitStr[i][0];
            String uid = splitStr[i][1];

            if (type.equals("Enter")) {
                list.add(map.get(uid) + ENTER_MSG);
            } else if (type.equals("Leave")) {
                list.add(map.get(uid) + LEAVE_MSG);
            }
        }

        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        System.out.println(Arrays.toString(test.solution(record)));
    }
}
