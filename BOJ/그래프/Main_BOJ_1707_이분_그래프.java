import java.util.*;
import java.io.*;

/**
 * BOJ 1707 이분 그래프
 * 2021.03.06
 * : bfs를 이용하여 풀었음
 * @author 0JUUU
 *
 */
public class Main_BOJ_1707_이분_그래프 {
	
	static int V, E;
	static Deque<Integer> queue = new LinkedList<>();
	static int[] color;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int tc= 1; tc<=K;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			queue.clear();
			color = new int[V+1];
			Vertex[] v = new Vertex[V+1];
			for(int i = 0; i<=V;i++) {
				v[i]= new Vertex();
			}
			
			for(int i = 0; i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				v[a].edge.add(b);
				v[b].edge.add(a);
			}
			boolean isBipartite = true;
	

			for(int i = 1; i<=V;i++) {
				if(color[i] != 0) continue;
				queue.offer(i);
				color[i] = 1;
				while(!queue.isEmpty()) {
					int cur = queue.pollFirst();
					for(int j = 0, size = v[cur].edge.size(); j<size; j++) {
						int next = v[cur].edge.get(j);
						
						if(color[next] != 0 && color[next] == color[cur]) {
							isBipartite = false; break;
						} else if(color[next] != 0) continue;
						color[next] = color[cur] == 1 ? 2 : 1;
						queue.addLast(next);
					}
					if(!isBipartite) break;
				}
				if(!isBipartite) break;
			}
			
			if(isBipartite) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb);
	}
}

class Vertex {
	int color;
	ArrayList<Integer> edge;
	public Vertex() {
		super();
		color = 0;
		edge = new ArrayList<>();
	}
}
