import java.util.*;
import java.io.*;

public class Main_BOJ_14467_소가_길을_건너간_이유_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cows = new int[11];
		Arrays.fill(cows, -1);
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int count = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int cowNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			if(cows[cowNum] == dir) continue;
			if(cows[cowNum] == -1) cows[cowNum] = dir;
			else {
				cows[cowNum] = dir;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
