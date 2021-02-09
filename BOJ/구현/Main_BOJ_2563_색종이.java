import java.util.*;
import java.io.*;

/**
 * BOJ 2563. 색종이
 * 2021.02.09
 * @author 0JUUU
 *
 */
public class Main_BOJ_2563_색종이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int paper = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int answer = 0;
		for(int p = 0; p<paper; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
	
			for(int i = startX; i <startX+10;i++) {
				for(int j = startY; j<startY+10;j++) {
					if(arr[i][j] == 0) {
						arr[i][j] = 1;
						answer++;
					}
				}
			}
			
		}
		System.out.println(answer);
		
	}
}
