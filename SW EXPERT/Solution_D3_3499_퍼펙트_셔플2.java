import java.util.*;
import java.io.*;

/**
 * SWEA 3499. 퍼펙트 셔플
 * : 1. 큐 2개를 이용해서 풀이 
 * : 2. 배열 인덱스값을 이용해서 풀이 (0)
 * @author 0JUUU
 *
 */
public class Solution_D3_3499_퍼펙트_셔플2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean isEven = N % 2 == 0? true : false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] s = new String[N];
			for(int i = 0; i<N;i++) s[i] = st.nextToken();
			sb.append("#").append(tc);
			int i = 0; int j = 0; int limit = 0;
			if(isEven) j = N/2;
			else j = N/2 + 1;
			limit = j;
			for(;i<limit ;i++, j++) {
				sb.append(" ").append(s[i]); 
				if(j != N) sb.append(" ").append(s[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
