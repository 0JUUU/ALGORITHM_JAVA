import java.util.*;
import java.io.*;

/**
 * BOJ 2493. 탑
 * 2021.02.04
 * : 스택과 큐를 이용하여 풀었다
 * : 전에 C++ 풀었을 때는 시간초과가 났던 것을 지금은 풀게 되어서 기쁘다 깔깔~
 * @author 0JUUU
 *
 */
public class Main_BOJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		Stack<int[]> stack = new Stack<>();

		int num = 1;
		while (st.hasMoreTokens()) {
			q.offer(new int[] { Integer.parseInt(st.nextToken()), num++ });
		}

		while (!q.isEmpty()) {
			if (stack.isEmpty()) { 		// 1번탑의 경우 : 수신 닿는 곳이 절대 없음 0 추가 
										// 나머지 탑 : STACK에 자기 자신보다 큰 값이 없는 경우, 밑의 과정을 처리하고 이쪽으로 오게 됨
				stack.add(q.poll());
				sb.append(0).append(" ");
			} else { 					// 나머지 탑의 경우
				int[] top = stack.peek();
				int[] front = q.peek();	
				if (top[0] >= front[0]) {	// 나보다 큰 탑이 있으면 수신이 닿는 곳
					sb.append(top[1]).append(" ");
					stack.push(q.poll());
				} else {
					while (top[0] < front[0]) {		// 현재 스택의 TOP보다 큰 경우 나보다 큰 탑이 있는지 확인하는 로직
						stack.pop();
						if (stack.isEmpty()) {
							break;
						}
						top = stack.peek();
					}
				}
			}
		}
		System.out.println(sb);
	}
}
