import java.util.*;
import java.io.*;

/**
 * BOJ 9548 무제
 * 2021.09.22
 * 1. String s += => 시간이 많이 드는 연산
 * 2. StringBuilder의 메소드를 잘 알고 활용하자. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_9548_무제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringBuilder sOp = new StringBuilder();
		StringTokenizer st;
		String op;
		for(int i = 0; i<T; i++) {
			sOp = new StringBuilder(br.readLine());
			op = "";
			while( (op = br.readLine()).charAt(0) != 'E') {
				st = new StringTokenizer(op);
				int X, Y;
				switch (st.nextToken()) {
				case "I":
					String R = st.nextToken();
					X = Integer.parseInt(st.nextToken());
					if(sOp.length() <= X) sOp.append(R);
					else {
						sOp.insert(X, R);
					}
					break;
				case "P":
					X = Integer.parseInt(st.nextToken());
					Y = Integer.parseInt(st.nextToken());
					sb.append(sOp.substring(X, Y+1) + "\n");
					break;
				default:
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
