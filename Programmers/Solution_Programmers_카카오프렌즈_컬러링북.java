import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] visited = new int[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(visited[i][j] != 0) continue;
                if(picture[i][j] == 0) continue;
                visited[i][j] = picture[i][j];
                numberOfArea++;
                int sum = 1;
                queue.add(new int[] {i, j});
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for(int dir = 0; dir<4;dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if(nx < 0 || nx >= m || ny < 0 || ny>= n) continue;
                        if(visited[nx][ny] != 0) continue;
                        if(picture[cur[0]][cur[1]] != picture[nx][ny]) continue;
                        visited[nx][ny] = picture[nx][ny];
                        queue.add(new int[] {nx, ny});
                        sum++;
                    }
                }
                maxSizeOfOneArea = sum > maxSizeOfOneArea ? sum : maxSizeOfOneArea;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}