import java.util.*;
import java.io.*;

/**
 * BOJ 12782 비트 우정지수
 * 2021.09.13
 * : 같은 인덱스 -> 일치하면 문자열 삭제 => MLE (메모리 초과)
 * 이를 그냥 같은 인덱스 -> 일치하면 건너뜀 / 다르면 개수 세기로 변경
 * @author 0JUUU
 *
 */
public class Main_BOJ_12782_비트_우정지수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			String one = st.nextToken();
			String two = st.nextToken();
			int len = one.length();
			int oneCount = 0, zeroCount = 0;
			for(int i = 0; i<len; i++) {
				if(one.charAt(i) == two.charAt(i)) continue;
				if(one.charAt(i) == '0') zeroCount++;
				else oneCount++;
			}
			
			sb.append((oneCount > zeroCount ? oneCount : zeroCount) + "\n");
		}
		System.out.println(sb);
	}
}
