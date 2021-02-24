import java.util.*;
import java.io.*;

/**
 * BOJ 2999 비밀 이메일
 * 2021.02.24
 * : 주어진 입력이 암호문이라는 것을 유의해야함!
 * : 처음 풀 때, 입력이 암호로 만들어야할 문장인 줄 알았음
 * @author 0JUUU
 *
 */
public class Main_BOJ_2999_비밀_이메일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = new String(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = msg.length();
		int R = 0, C = 0;
		for(int i = (int)Math.sqrt(N) + 1 ; i>=1;i--) {
			int j = 0;
			if(N%i == 0) {
				j = N/i;
				R = i < j ? i : j;
				C = R == i ? j : i;
				break;
			}
		}
		
		char[][] arr= new char[R][C];
		for(int j = 0; j<C;j++) {
			for(int i = 0; i<R;i++) {
				arr[i][j] = msg.charAt(j * R + i
						);
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				sb.append(arr[i][j]);
			}
		}
		System.out.println(sb);
	}
}
