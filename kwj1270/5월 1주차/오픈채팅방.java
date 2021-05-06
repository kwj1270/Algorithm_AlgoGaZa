import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> m = new HashMap<>(); // id랑 닉네임, 명령어 저장 용도
        List<String> nicknames = new ArrayList<>();
        
        
        for (int i = 0; i < record.length; i++) {
            String id;
            String nickname;
            String[] words = record[i].split(" ");
            if (words[0].equals("Change")) {
                id = words[1];
                nickname = words[2];
                m.put(id, nickname);
                continue;
            }
            if (words[0].equals("Leave")) {
                id = words[1];
                nicknames.add(id);
                answer.add("님이 나갔습니다.");
                continue;
            }
            if (words[0].equals("Enter")) {
                id = words[1];
                nickname = words[2];
                m.put(id, nickname);
                nicknames.add(id);
                answer.add("님이 들어왔습니다.");
                continue;
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            answer.set(i, m.get(nicknames.get(i)) + answer.get(i));
        }
        return answer.toArray(new String[answer.size()]);
    }
}
