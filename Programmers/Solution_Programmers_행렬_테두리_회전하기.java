class Solution_Programmers_행렬_테두리_회전하기 {
    static int[] dx = {1, 0, -1, 0};	// 하우상좌
	static int[] dy = {0,1,0,-1};	// 하우상좌
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int querySize = queries.length;
        int[][] matrix = new int[rows+1][columns+1];
        int num = 1;
        // 행렬 초기화
        for(int i = 1; i<=rows;i++) {
        	for(int j = 1; j<=columns;j++) {
        		matrix[i][j] = num++;
        	}
        }
        
        answer = new int[querySize];
        for(int q = 0; q<querySize;q++) {
        	int minNum = Integer.MAX_VALUE;
        	int dir = 0;
        	
        	int x1= queries[q][0];
        	int y1= queries[q][1];
        	int x2= queries[q][2];
        	int y2= queries[q][3];
        	
        	int cx = x1;
        	int cy = y1;
        	int tmp = matrix[cx][cy];
        	minNum = tmp;
        	// 회전
        	while(true) {
        		int nx = cx + dx[dir];
        		int ny = cy + dy[dir];
        		if(nx == x1 && ny == y1) {
        			matrix[cx][cy] = tmp;
        			break;
        		}
        		if(nx < x1 || nx > x2 || ny < y1 || ny > y2) {
        			dir++;
        			continue;
        		}
        		minNum = minNum > matrix[nx][ny] ? matrix[nx][ny] : minNum;
        		matrix[cx][cy] = matrix[nx][ny];
        		cx = nx;
        		cy = ny;
        	}
        	answer[q] = minNum;
        }
        return answer;
    }
}