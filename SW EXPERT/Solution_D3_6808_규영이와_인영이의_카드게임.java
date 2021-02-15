import java.util.*;
import java.io.*;

/**
 * SWEA 6808 규영이와 인영이의 카드게임
 * 2021.02.15
 * @author 0JUUU
 *
 */
public class Solution_D3_6808_규영이와_인영이의_카드게임 {
	static int[] gyuyoung, inyoung, card;
	static int N = 9, win, lose;
	static boolean[] isSelected, isUsed;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
 		for(int tc = 1; tc<=T;tc++) {
 			gyuyoung = new int[9];
 			inyoung = new int[9];
 			card = new int[9];
 			isSelected = new boolean[9];
 			isUsed = new boolean[19];
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			for(int i = 0; i<9;i++) {		// 규영이 카드 입력(순서 고정)
 				gyuyoung[i] = Integer.parseInt(st.nextToken());
 				isUsed[gyuyoung[i]] = true;		// 규영이가 입력한 수를 표시
 			}	
 			int index = 0;
 			for(int i = 1; i<=18;i++) {
 				if (isUsed[i]) continue;
 				inyoung[index++] = i;
 			}

 			permutation(0);
 			sb.append("#" + tc + " "+ win + " " + lose + "\n");
 			win = 0; lose = 0;
 		}
 		System.out.print(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == 9) {	// 9개의 수를 모두 뽑은 상황
			int sumGyu = 0;
			int sumIn = 0;
			for(int i = 0; i<9;i++) {
				if(gyuyoung[i] < card[i]) {
					sumIn += gyuyoung[i] + card[i];
				} else if(gyuyoung[i] > card[i]) {
					sumGyu += gyuyoung[i] + card[i];
				}
			}
			if(sumGyu > sumIn) win++;
			else if(sumGyu < sumIn) lose++;
			return;		
		}
		for(int i = 0; i<9;i++) {
			if(isSelected[i]) continue;
			card[cnt] = inyoung[i]; 
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
