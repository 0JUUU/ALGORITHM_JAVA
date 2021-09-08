import java.util.*;
import java.io.*;

/**
 * BOJ 5568 카드 놓기
 * 2021.09.08
 * : 순열 이용
 * @author 0JUUU
 *
 */

public class Main_BOJ_5568_카드놓기 {

	static int n, k, countInteger;
	static int[] cards, select;
	static boolean[] isSelected;
	static HashMap<String, Boolean> makeNumber = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		cards = new int[n];
		isSelected = new boolean[n];
		select = new int[k];
		for(int i = 0; i<n; i++) {
			cards[i] = Integer.parseInt(br.readLine());
		}
		
		makePerm(0);
		System.out.println(countInteger);
	}
	private static void makePerm(int cnt) {
		if(cnt == k) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<k; i++) {
				sb.append(select[i]);
			}
			String number = sb.toString();
			if(makeNumber.get(number) != null) return;
			makeNumber.put(number, true);
			countInteger++;
			return;
		}
		
		for(int i = 0; i<n;i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			select[cnt] = cards[i];
			makePerm(cnt+1);
			isSelected[i] = false;
		}
	}
}
