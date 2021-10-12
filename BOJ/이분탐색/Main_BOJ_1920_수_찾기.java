import java.util.*;
import java.io.*;

/**
 * BOJ 1920 수 찾기
 * 2021.10.12
 * : left, right 값 설정의 중요성 => 굳이 한 번 더 같은 걸 반복할 필요는 없다!
 * @author 0JUUU
 *
 */
public class Main_BOJ_1920_수_찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			boolean isFind = false;
			int start = 0;
			int end = N-1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(A[mid] == num) {
					isFind = true;
					break;
				}
				if(A[mid] < num) {	
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			
			if(isFind) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		
		System.out.println(sb);
	}
}
