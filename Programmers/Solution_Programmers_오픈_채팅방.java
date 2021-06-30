import java.util.*;

/**
    2019 KAKAO BLIND RECRUITMENT 오픈채팅방
    2021.06.30
    2번의 과정을 거친다.
    1. 최종적으로 수정되는 닉네임까지 반영하여 HashMap에 저장한다.
    2. 최종 닉네임으로 들어왔습니다./나갔습니다. 를 출력한다.
**/

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        LinkedList<String> answerList = new LinkedList<String>();
       
        HashMap<String, String> user = new HashMap<>();
        StringTokenizer st;
        // 한 번 돌아서 최종 id 
        int length = record.length;
        for(int i = 0; i<length;i++) {
            st = new StringTokenizer(record[i]);
            String operand = st.nextToken();
            if(operand.equals("Leave")) {
                st.nextToken();
                continue;
            }
            
            String id = st.nextToken();
            String nickName = st.nextToken();
            user.put(id, nickName);
        }
        
        // 다시 record 돌아서 최종 id로 들 나 출력
        for(int i = 0; i<length;i++) {
            st = new StringTokenizer(record[i]);
            String operand = st.nextToken();
            String id = st.nextToken();
            String nickName = user.get(id);
            if(operand.equals("Leave")) {
                answerList.add(nickName+"님이 나갔습니다.");
            } else if(operand.equals("Enter")) {
                st.nextToken();
                answerList.add(nickName+"님이 들어왔습니다.");
            } else {
                st.nextToken();
            }
            
        }
        
        answer = new String[answerList.size()];
        int index = 0;
        while(!answerList.isEmpty()) {
            answer[index++] = answerList.poll();
        }
        return answer;
    }
}