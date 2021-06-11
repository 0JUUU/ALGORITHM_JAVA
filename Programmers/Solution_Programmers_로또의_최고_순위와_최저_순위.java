class Solution_Programmers_로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCnt = 0;
        int[] winNum = new int[46];
        // 당첨 번호 체크
        for(int i = 0; i<6;i++) {
            winNum[win_nums[i]]++;
        }
        
        int correctCnt = 0;
        for(int i = 0; i<6;i++) {
            if(lottos[i] == 0) zeroCnt++;
            else if(winNum[lottos[i]] != 0) {
                correctCnt++;
            }
        }
        int max = 0, min = 0;
        int[] score = {6,6,5,4,3,2,1};
        int sum = correctCnt+ zeroCnt;
        answer = new int[]{score[sum], score[correctCnt]};
        return answer;
    }
}