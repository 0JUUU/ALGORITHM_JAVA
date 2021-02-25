import java.util.*;
import java.io.*;

/***
 * SWEA 4789 성공적인 공연 기획
 * 2021.02.25
 * @author 0JUUU
 *
 */
public class Solution_D3_4789_성공적인_공연기획 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T;tc++) {
			int stand = 0, add = 0;
			String s = br.readLine();
			int num[] = new int[s.length()];
			for(int i =0; i<s.length();i++) {
				num[i] = s.charAt(i) - '0';
				if(i == 0) stand = num[i];
				else if(num[i] == 0) continue;
				else if(stand >= i) {
					stand += num[i];
				} else if(stand < i) {
					add += i - stand;
					stand = i + num[i];
				}
			}
			sb.append("#" + tc + " "+add + "\n");
		}
		System.out.println(sb);
	}
}
