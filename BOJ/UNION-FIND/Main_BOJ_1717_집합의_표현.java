import java.util.*;
import java.io.*;

/**
 * BOJ 1717 집합의 표현
 * 2021.03.08
 * : union-find 
 * : 1. 어디 최씹니까? 서로의 조상을 물어보는 것
 * : 2. 부모가 같다면, 더 돌아볼 필요도 없습니다.
 * : 3. 부모가 다른 채로 합친다면, 자신만의 기준을 가지고 하나로 합칩니다. 
 * : 합친 후, 갱신하는 것은 필수!
 * : 확인 후, 갱신하는 것도 필수 ! --> return number = getParent(parent[number]); 이것은 확인 후 갱신을 안했기에, 시간이 오래 걸린다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_1717_집합의_표현 {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 1; i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(op) {
				case 0: 
					union(a,b);
					break;
				case 1: 
					if(getParent(a) == getParent(b)) sb.append("YES\n");
					else sb.append("NO\n");
					break;
			}
		}
		System.out.print(sb);
	}
	
	static int getParent(int number) {
		if(number == parent[number]) {
			return number;
		}
		
		return parent[number] = getParent(parent[number]);		//return number = getParent(parent[number]); --> 이렇게 할 경우, 시간초과 
																// 결국 조상을 찾을 수는 있지만, 왔던걸 계속 다시 돌아보므로 시간이 오래 걸림
	}
	
	static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if(a != b) {
			if (a > b) parent[a] = b;
			else parent[b] = a;
		}
	}
}
