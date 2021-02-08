import java.util.*;
import java.io.*;

/**
 * SWEA 1228. 암호문1 2021.02.08
 * 
 * @author 0JUUU
 *
 */
public class Solution_D3_1228_암호문1 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<String> answer = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				answer.add(st.nextToken());
			}

			int C = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < C; i++) {
				st2.nextToken();
				int index = Integer.parseInt(st2.nextToken());
				int count = Integer.parseInt(st2.nextToken());
				for (int cnt = 0; cnt < count; cnt++) {
					answer.add(index + cnt, st2.nextToken());
				}
			}

			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(answer.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
