import java.util.*;
import java.io.*;
public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = "";
		
		while((s=br.readLine()) != null) {
			int T = Integer.parseInt(s);
			sb.append("#").append(T).append(" ");
			int[] arr = new int[8];
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<8;i++) {
				arr[i] = Integer.parseInt(st.nextToken());		// 배열에 수 저장
			}
			
			boolean isZero = false;
			int sub = 1;
			while(true) {
				
				for(int i = 0; i<8;i++) {
					arr[i] -= sub;
					if(sub < 5) sub++;
					else sub = 1;
					if(arr[i] <= 0) {
						arr[i] = 0;
						isZero = true;
						break;
					}
				}
				if(isZero == true) break;
			}
			
			if(arr[7] == 0) {	// 마지막 원소가 0이면 굳이 큐에 넣어 작업할 필요가 없음
				for(int i = 0; i<8;i++) {
					if(i == 7) sb.append(arr[i]).append("\n");
					else sb.append(arr[i]).append(" ");
				}
			}
			else {
				for(int i = 0; i<8;i++) {
					q.offer(arr[i]);
				}
				while(q.peek() != 0) {
					int cur = q.poll();
					q.offer(arr[cur]); //q.add(cur);
				}
				int zero = q.poll();
				q.offer(zero); //q.add(zero);
				
				for(int i = 0; i<8;i++) {
					if(i == 7) sb.append(q.poll()).append("\n");
					else sb.append(q.poll()).append(" ");
				}
			}
			
		}	// while
		System.out.println(sb);
	}	// main
}
