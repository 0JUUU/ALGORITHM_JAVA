import java.util.*;
import java.io.*;

/**
 * BOJ 1932 정수 삼각형
 * : 밑에서부터 위로 합쳐가는 과정의 dp
 * @author user
 *
 */
public class Main_BOJ_1932_정수_삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] numbers = new int[n][];
		int[][] max = new int[n-1][];
		for(int i = 0; i<n;i++) {
			numbers[i] = new int[i+1];
			if(i != n-1) max[i] = new int[i+1];
		}
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<i+1;j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = n-1; i>0;i--) {
            for(int j = 0; j<i;j++) {
                max[i-1][j] = numbers[i][j] > numbers[i][j+1] ? numbers[i][j] :numbers[i][j+1];
            }
            
            for(int j = 0; j<i;j++) {
                numbers[i-1][j] += max[i-1][j];
            }
        }
		
		System.out.println(numbers[0][0]);
	}
}
