import java.util.*;
import java.io.*;

/**
 * BOJ 6198. 옥상 정원 꾸미기
 * 2021.02.04
 * SSAFY 스터디
 * @author 0JUUU
 * : 스터디에서 배운 방식인 진행방향의 반대부터 stack에 넣고, 값을 비교하며 스택에 인덱스를 저장(=즉, 빌딩 번호)
 * : int의 범위를 넘는지 꼭 체크해야함!!! 값이 크면 무적권 걍 long을 넣는것도 나쁘지않은 것 같다. ㅋㅋ
 */

public class Main_BOJ_6198_옥상_정원_꾸미기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		long[] height = new long[N+2];
		long answer = 0;
		height[N+1] = 1000000001;
		
		for(int i = 1;i<=N;i++) {		// 배열에 저장
			height[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i<=N+1;i++) {
			if(stack.isEmpty()) stack.push(i);
			else {
				if(height[stack.peek()] > height[i]) stack.push(i);
				else {
					while(height[stack.peek()] <= height[i]) {
						answer += i - stack.peek() -1;
						stack.pop(); 
						if(stack.isEmpty()) break;
					}
					stack.add(i);
				}
			}
		}
		
		System.out.println(answer);
	}
}
