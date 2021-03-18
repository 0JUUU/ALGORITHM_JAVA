import java.util.*;
import java.io.*;

/**
 * SWEA 3289 서로소 집합
 * 2021.03.18
 * : union-find를 이용 ==> union을 잘 기억해두자. find는 생각나는데 union은 잘 ㅎㅎ
 * @author 0JUUU
 *
 */
public class Solution_SWEA_D4_3289_서로소_집합 {
	static int n, m;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			for(int i = 1; i<=n;i++) {
				parent[i] = i;
			}
			
			sb.append("#"+tc +" ");
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
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		if(a>b) parent[b] = a;
		else if(a<b) parent[a] = b;
	}
}
