import java.util.*;
import java.io.*;

/**
 * BOJ 14719 빗물
 * 2021.03.15
 * : 최고층 블록을 기준으로 왼쪽과 오른쪽으로 나누어 계산한다. 
 * @author 0JUUU
 *
 */
public class Main_BOJ_14719_빗물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] block = new int[W];
		st = new StringTokenizer(br.readLine());
		int maxH = 0, maxH_index = 0;
		for(int i = 0; i<W;i++) {
			block[i] = Integer.parseInt(st.nextToken());
			if(maxH < block[i]) {
				maxH = block[i];
				maxH_index = i;
			}
		}
		
		int maxLeft = 0, maxRight = 0;
		int sumLeft = 0, sumRight = 0;
		// 왼쪽
		for(int i = 0; i<maxH_index;i++) {
			if(maxLeft < block[i]) {
				maxLeft = block[i];
			}
			else {
				sumLeft += maxLeft - block[i];
			}
		}
		
		// 오른쪽
		for(int i = W-1;i >maxH_index;i--) {
			if(maxRight < block[i]) {
				maxRight = block[i];
			} else {
				sumRight += maxRight - block[i];
			}
		}
		
		System.out.println(sumLeft + sumRight);
	}
}
