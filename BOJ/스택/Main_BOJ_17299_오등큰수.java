import java.util.*;
import java.io.*;

/**
 * BOJ 17299 오등큰수
 * 2021.02.22
 * @author 0JUUU
 *
 */
public class Main_BOJ_17299_오등큰수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] count = new int[1000001];
		int max = 0;
		Stack<Integer> big = new Stack<>();
		Stack<String> answer = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
			max = max<count[arr[i]] ?count[arr[i]] : max;
		}
		for(int i = N-1;i>=0;i--) {
			if(max == count[arr[i]]) {
				if(!big.isEmpty()) big.clear();
				big.add(arr[i]);
				answer.add(-1 + " ");
				//sb.append(-1 + " ");
			} else {
				if(big.isEmpty()) {
					answer.add(-1 + " ");
					//sb.append(-1 + " ");	// 제일 크지는 않지만 맨 뒤에 있는 경우
					big.add(arr[i]);
				} else {
					int top = big.peek();
					if(count[arr[i]] < count[top]) {
						answer.add(top + " ");
						//sb.append(top + " ");
						big.add(arr[i]);
					} else {
						while(!big.isEmpty() && count[arr[i]] >= count[top]) {
							big.pop();
							if(!big.isEmpty()) top = big.peek();
						}
						if(big.isEmpty()) answer.add(-1 + " ");
						else answer.add(top + " ");
						//sb.append(top + " ");
						big.add(arr[i]);
					}
				}
			}
		}
		while(!answer.isEmpty()) {
			sb.append(answer.pop());
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
