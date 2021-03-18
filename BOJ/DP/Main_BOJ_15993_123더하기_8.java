import java.util.*;
import java.io.*;

/**
 * BOJ 15993 1,2,3 더하기 8
 * 2021.03.18
 * : dp에서 odd를 빼게 되면 나머지값이 dp가 더 작을 수도 있다. 그냥 odd와 even으로 나누어 계산해라~
 * : 무슨 말인지 모르겠다면 boj에 제출한 코드들을 봐라 이놈아
 *  * @author 0JUUU	
 *
 */
public class Main_BOJ_15993_123더하기_8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[100001];
		long[] odd = new long[100001];
		long[] even = new long[100001];
		
		odd[1] = 1; odd[2] = 1; odd[3] = 2;
		even[1] = 0; even[2] = 1; even[3] = 2; 
		for(int i = 4; i<=100000;i++) {
			odd[i] = (even[i-1] + even[i-2] + even[i-3]) % 1000000009;
			even[i] = (odd[i-1] + odd[i-2] + odd[i-3]) % 1000000009;
		}
		for(int tc = 0; tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(odd[n] + " " + even[n] + "\n");
		}
		System.out.print(sb);
	}
}
