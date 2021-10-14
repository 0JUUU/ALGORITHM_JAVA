import java.util.*;
import java.io.*;

/**
 * BOJ 20164 홀수 홀릭 호석
 * 2021.10.14
 * : 브루트포스로 해결 (조합)
 * @author 0JUUU
 *
 */
public class Main_BOJ_20164_홀수_홀릭_호석 {

	static int min, max, len;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		len = N.length;

		if(len < 2) {
			if((N[0] - '0') % 2 == 0) System.out.println("0 0");
			else System.out.println("1 1");
		} else {
			calc(N, 0);
			System.out.println(min + " " + max);
		}
		
	}
	private static void calc(char[] N, int count) {
		int len = N.length;
		
		// 현재 들어온 수 N에 대하여 홀수 개수 체크
		for(int i = 0; i<len; i++) {
			if((N[i] - '0') % 2 == 1) {
				count += 1;
			}
		}
		
		if(len == 1) {
			max = count > max ? count : max;
			min = min > count ? count : min;
			return;
		} else if(len == 2) {
			// 2자리 수 각각 더해서 다음으로 보내기
			int first = N[0] - '0';
			int second = N[1] - '0';
			String sum = Integer.toString(first + second);
			calc(sum.toCharArray(), count);
		} else {
			for(int i = 1; i<len-1; i++) {
				for(int j = i+1; j < len; j++) {
					int firstIndex = 0; int first = 0;
					int secondIndex = i; int second = 0;
					int thirdIndex = j; int third = 0;
					
					for(int k = 0; k < secondIndex; k++) {
						first += (N[k] - '0') * Math.pow(10, secondIndex - k -1);
					}
					
					for(int k = secondIndex; k < thirdIndex; k++) {
						second += (N[k] - '0') * Math.pow(10, thirdIndex - k -1);
					}
					
					for(int k = thirdIndex; k < len; k++) {
						third += (N[k] - '0') * Math.pow(10, len - k -1);
					}
					
					//System.out.println("first >> " + first + " / second >> " + second + " / third >> "+ third);
					String sum = Integer.toString(first+second+third);
					calc(sum.toCharArray(), count);
				}
			}
		}
	}
}
