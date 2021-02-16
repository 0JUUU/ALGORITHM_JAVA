import java.util.*;
import java.io.*;

/**
 * BOJ 17281 야구공
 * 2021.02.16
 * : 1. next_permutation(이하 np)를 이용해 타순을 정함
 * : 2. 각 선수가 공을 친 후의 상황을 표기
 * @author 0JUUU
 *
 */
public class Main_BOJ_17281_야구공 {
	static int N; // 이닝수
	static int[][] result;	// 각 이닝에서 획득할 수 있는 점수
	static int max, out, start, inning;
	static int[] order = new int[10];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[N+1][10];
		StringTokenizer st;
		for(int i = 1; i<=N;i++) {		
			 st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=9;j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//order[4] = 1;	// 1번 선수는 4번 타자로 -> 나중에 처리
		for(int i = 2; i<=9;i++) {
			order[i-1] = i;
		}
		int count = 0;
		max = Integer.MIN_VALUE;
		do {
			start = 1;
			out = 0;
			inning = 1;
			for(int i = 8; i>=4;i--) {
				order[i+1] = order[i];
			}
			order[4] = 1;	// 이렇게 해서 순열을 구함
			int s = getScore();
			max = max < s ? s : max;
			for(int i = 5; i<=9;i++) {	// 배열에서 1을 빼서 되돌려놓기
				order[i-1]=order[i];
			}
			count++;
		}while(nextPermutation());
		
		System.out.println(max);
	}
	
	static boolean nextPermutation() {
		int i = 8;		// 꼭대기의 위치(max를 의미하는 것은 아님)
		while(i > 1 && order[i-1] >= order[i]) --i;
		
		// 더 이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열의 상태(마지막 순열)
		if(i == 1) return false;
		
		int j = 8;
		while(order[i-1] >= order[j]) j--;		// 얘는 어차피 i일때 항상 i-1값보다 크므로 다른 조건 넣지않아도 됨
		
		swap(i-1, j);
		
		int k = 8;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = order[i];
		order[i] =  order[j];
		order[j] = temp;
	}
	
	static int getScore() {
		int flag = 0; int score = 0;
		while(inning != N + 1) {
			switch(result[inning][order[start]]) {
			case 0: // 아웃
				out++;
				break;
			case 1: // 1루
				if(flag == 0) flag = 1;
				else flag = ((flag << 1) | 1);
				if((flag & 1 << 3) != 0) score++;
				break;
			case 2: // 2루
				if(flag == 0) flag = 2;
				else {
					for(int i = 1; i<=2;i++) {			// 이미 나가 있는 애들 처리
						flag = flag << 1;
						if((flag & 1 << 3) != 0) score++;
					}
					flag = flag | 2;
				}
				break;
			case 3: // 3루
				if(flag == 0) flag = 4;
				else {
					for(int i = 1; i<=3;i++) {
						flag = (flag << 1);
						if((flag & 1 << 3) != 0) score++;
					}
					flag = flag | 4;
				}
				break;
			case 4: // 홈런
				if(flag == 0) score++;
				else {
					for(int i = 1; i<=4;i++) {
						flag = (flag << 1);
						if((flag & 1 << 3) != 0) score++;
					}
					score++;
				}
				break;
			}
			if((flag & 31) == 0) flag = 0;
			if(start != 9) start += 1;	// 다음 타자 지정
			else start = 1;
			if(out == 3) {
				inning++;
				out = 0;
				flag = 0;
			}
		}
		return score;
	}
}
