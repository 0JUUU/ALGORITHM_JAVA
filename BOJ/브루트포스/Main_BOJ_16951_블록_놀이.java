import java.util.*;
import java.io.*;

/**
 * BOJ 16951 블록 높이
 * 2021.11.11
 * : 가장 적게 변경하는 방법을 고수 
 * => 1~N까지 하나의 값을 고정시켜놓고 그 위치에 그 값일 경우의 A1 값을 임시로 구한 후,
 * A1 같에 K를 더해가며 Ai의 높이값과 같은지 비교
 * => 다르면 변경해줘야하는 것이므로 시간++
 * => 같으면 그냥 넘어감
 * (이 떄, 임시 A1의 값이 0보다 작거나 같으면 그냥 시도조차 하지 않음)
 * @author 0JUUU
 *
 */
public class Main_BOJ_16951_블록_놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] blocks = new int[N+1];
		for(int i = 1; i <= N; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = 1001;
		for(int i = 1; i<=N; i++) {
			int start = i;	// 얘를 고정시켜놓고 임시A1 구하기
			int tmpMin = 0;
			int tmpA1 = blocks[i] - (K * (i-1));
			if(tmpA1 <= 0) continue;
			for(int j = 1; j<=N; j++) {
				if(blocks[j] != (tmpA1 + K*(j-1))) {
					tmpMin++;
				}
			}
			
			if(tmpMin == 0) {
				min = 0;
				break;
			}
			min = min > tmpMin ? tmpMin : min;
		}
		
		System.out.println(min);
	}
}
