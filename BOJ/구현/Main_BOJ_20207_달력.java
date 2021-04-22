import java.util.*;
import java.io.*;

public class Main_BOJ_20207_달력 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] day = new int[370];
		int maxNum = 0;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			maxNum = end > maxNum ? end : maxNum;
			for(int j = start; j<=end;j++) {
				day[j]++;
			}
		}
		
		int index = 1, len =0, max = 0, sum = 0;
		while(index != maxNum+2) {
			if(day[index] != 0) {
				max = max < day[index] ? day[index]:max;
				len++;
			}
			else if(len != 0 && day[index] == 0) {
				sum += (max * len);
				len = 0; max = 0;
			}
			
			index++; 
		}
		System.out.println(sum);
;	}
}
