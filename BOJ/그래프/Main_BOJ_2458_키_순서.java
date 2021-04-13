import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2456 키 순서
 * 2021.04.13
 * : 부모(먼저 나가는 애들)과 자식(나보다 뒤에 나가는 애들)의 개수를 체크해서 총 학생의 수 -1이라면
 * : 절대적인 내 순서를 알 수 있는 것이므로 이러한 생각을 이용하여 풀었음
 * @author 0JUUU
 *
 */
public class Main_BOJ_2458_키_순서 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] child = new int[N+1][N+1];
		int[][] parent = new int[N+1][N+1];
		for(int i = 0; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			parent[a][b] = 1;
			child[b][a] = 1;
		}
		for(int i = 1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(parent[i][j] == 1) {
					for(int k = 1; k<=N;k++) {
						if(child[i][k] == 1) {
							parent[k][j] = 1;
							child[j][k] = 1;
						}
					}
				}
			}
		}
		int[] count = new int[N+1];
		
		for(int i=1; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(child[i][j] == 1) count[i]++;
				if(parent[i][j] == 1) count[i]++;
			}
		}
		
		int person = 0;
		for(int i =1; i<=N;i++) {
			if(count[i] == N-1) person++;
		}
		System.out.println(person);
	}
}
