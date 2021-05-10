import java.util.*;
import java.io.*;

/**
 * BOJ 15922 아우으 우아으이야!!
 * 2021.05.11
 * : 이전 y 와 현재 x를 비교하여 값을 더할지 말지 결정
 * [더하지않는다면]
 * : 이전 y와 현재 y를 비교하여 큰 값을 저장
 * [더한다면]
 * : 총합에 더하고, 현재 x, y 저장
 * @author 0JUUU
 *
 */
public class Main_BOJ_15922_아우으_우아으이야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int length = 0, tmpX, tmpY;
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			x[i] = a; y[i] = b;
		}
		
		tmpX = x[0]; tmpY = y[0];
		for(int i = 1; i<N;i++) {
			if(tmpY >= x[i]) {
				tmpY = y[i] > tmpY ? y[i] : tmpY;
			} else {
				length += tmpY - tmpX;
				tmpX = x[i];
				tmpY= y[i];
			}
		}
		length += (tmpY - tmpX);
		System.out.println(length);
	}
}
