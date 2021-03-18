import java.util.*;
import java.io.*;

/**
 * JUNGOL 1863 종교
 * 2021.03.18
 * : root인 애는 음수값을 가지고, root가 아닌 애들은 parent배열의 값이 root를 가리키게 된다.
 * @author 0JUUU
 *
 */
public class Main_JUNGOL_1863_종교 {
	static int n, m, count;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		Arrays.fill(parent, -1);
		parent[0] = 0;
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		for(int i = 1; i<=n;i++) {
			if(parent[i] < 0) count++;
		}
		System.out.println(count);
	}
	
	private static int find(int a) {
		if(parent[a] < 0) return a;
		return parent[a] = find(parent[a]);
 	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		else if(a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
}
