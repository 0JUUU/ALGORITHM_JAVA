import java.util.*;
import java.io.*;

public class Main_BOJ_11724_연결_요소의_개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[N+1];
		int count = 0;
		Node[] node = new Node[N+1];
		for(int i =0; i<=N;i++) {
			node[i] = new Node();
		}
		for(int i = 0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
			
			node[a].connect.add(b);
			node[b].connect.add(a);
		}
		if(M > (N-1) * (N-2)/2) System.out.println(1);
		else {
			for(int i = 1; i<=N;i++) {
				if(visited[i] != 0) continue;
				visited[i] = ++count;
				queue.add(i);
				while(!queue.isEmpty()) {
					int cur = queue.pollFirst();
					for(int index = 0; index<node[cur].connect.size();index++) {
						int next = node[cur].connect.get(index);
						if(visited[next] != 0) continue;
						visited[next] = visited[cur];
						queue.add(next);
					}
				}
			}
			System.out.println(count);
		}
	}
}

class Node {
	int number;
	ArrayList<Integer> connect = new ArrayList<>();
	
	public Node() {
		super();
		connect = new ArrayList<>();
	}
}
