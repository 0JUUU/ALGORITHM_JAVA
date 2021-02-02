
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flattern {
//	static String inputStr = "";		// 테케 내용 복사
	
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader/*reader*/(System.in/*inputstream*/));
//		StringReader sr = new StringReader(inputStr);
		
		BufferedReader br = new BufferedReader(new InputStreamReader/*reader*/(System.in/*inputstream*/));	
//					   br = new BufferedReader(new StringReader(inputStr));
		
		for(int tc = 1;tc<=10;tc++ ) {
			int ans = 0;
			int dump = Integer.parseInt(br.readLine());
			Integer[] box = new Integer[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
// 			char[] chArr = br.readLine().toCharArray();
			for(int i = 0;i<100;i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0;i<dump;i++) {
				Arrays.sort(box, Collections.reverseOrder());
				box[0]--; box[99]++;
			}
			Arrays.sort(box, Collections.reverseOrder());
			ans = box[0] - box[99];
			System.out.println("#"+tc+" " + ans);
		}
	}
}
