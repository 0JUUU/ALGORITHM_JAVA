import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 2001. 파리 퇴치
 * 2021.02.03
 * @author 0JUUU
 *
 */
public class Solution_D2_2001_파리_퇴치 {
	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("input_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] fly = new int[N][N];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<N;j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
				//System.out.println(Arrays.toString(fly[i]));
			}
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for(int i = 0; (i+M) <= N;i++) {
				for(int j = 0;j+M<=N;j++) {
					sum = 0;
					for(int x = 0;x<M;x++) {
						for(int y = 0;y<M;y++) {
							sum += fly[i+x][j+y];
						}
					}
					if(max < sum) max = sum;
				}
			}
			System.out.println("#" + tc+ " " +max);
		}

	}
}
