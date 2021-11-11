import java.util.*;
import java.io.*;

/**
 * BOJ 2668 숫자고르기
 * 2021.11.11
 * : DFS로
 * @author 0JUUU
 *
 */
public class Main_BOJ_2668_숫자고르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] board = new int[N+1];
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> candidate = new HashMap<>();
		int count = 0;
		for(int i = 1; i<=N; i++) {
			board[i] = Integer.parseInt(br.readLine());
			if(!candidate.containsKey(board[i])) {
				count++;
				candidate.put(board[i], 1);
			}
			
			if(board[i] == i) {
				list.add(board[i]);
			}
		}
		
		if(count == N) {
			sb.append(N+"\n");
			for(int i = 1; i<=N; i++) {
				sb.append(i+"\n");
			}
		} else {
			int maxCount = 0;
			int[] visited = new int[N+1];
			for(Integer same : list) {
				visited[same] = 1;
			}
			for(int i =1; i<=N; i++) {
				// start지점
				if(visited[i] != 0) continue;
				if(board[i] == i) continue;
				int[] select = new int[N+1];
				int[] check = new int[N+1];
				int cur = i;
				int next = board[i];
				int checkCount = 0;
				boolean isAll = true;
				while(check[next] == 0) {
					next = board[cur];
					if(visited[next] != 0) {
						isAll = false;
						break;
					}
						
					check[cur] = next;
					cur = next;
					checkCount++;
				}
				

				cur = i;
				boolean isFind = false;
				for(int j =1; j<=N; j++) {
					if(check[j] == cur) {
						isFind = true;
						break;
					}
				}
				
				if(!isFind) isAll = false;
				while(isAll) {
					if(check[cur] == 0) {
						isAll = false;
						break;
					}
					cur = check[cur];
					checkCount--;
					if(checkCount == 0) break;
				}
				if(isAll) {
					for(int j = 1; j<=N; j++) {
						if(check[j] != 0) {
							list.add(j);
							visited[j] = 1;
						}
					}
				}
			}
			
			Collections.sort(list);
			sb.append(list.size()+"\n");
			for(Integer num : list) {
				sb.append(num + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
