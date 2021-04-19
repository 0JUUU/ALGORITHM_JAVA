import java.util.*;
import java.io.*;

/**
 * BOJ 14888 연산자 끼워넣기
 * 2021.04.19
 * @author 0JUUU
 *
 */
public class Main_BOJ_14888_연산자_끼워넣기 {
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] number;
	static boolean[] isSelected;
	static ArrayList<Integer> operator = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		number = new int[N];
		for(int i = 0; i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int op = 0;
		for(int i = 0; i<4;i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int c = 0; c<count;c++) {
				operator.add(op);
			}
			op++;
		}
		isSelected = new boolean[N-1];
		perm(0, number[0]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void perm(int cnt, int sum) {
		if(cnt == N-1) {
			max = max < sum ? sum : max;
			min = min > sum ? sum : min;
			return;
		}
		// TODO Auto-generated method stub
		for(int i = 0; i<N-1;i++) {
			if(isSelected[i]) continue;
			int op = operator.get(i);
			isSelected[i] = true;
			switch(op) {
			case 0:
				perm(cnt + 1, sum + number[cnt+1]);
				break;
			case 1:
				perm(cnt + 1, sum - number[cnt+1]);
				break;
			case 2:
				perm(cnt + 1, sum * number[cnt+1]);
				break;
			case 3: 
				perm(cnt + 1, sum / number[cnt+1]);
				break;
			}
			isSelected[i] = false;
		}
	}
	
}
