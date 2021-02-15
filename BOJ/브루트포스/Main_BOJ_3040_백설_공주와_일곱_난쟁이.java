import java.util.*;
import java.io.*;

/**
 * BOJ 3040 백설공주와 일곱 난쟁이
 * 2021.02.15
 * : 조합하는 방법을 겁나 연구해야겠음 ㅜㅜ
 * @author 0JUUU
 *
 */
public class Main_BOJ_3040_백설_공주와_일곱_난쟁이 {
	static int[] nine = new int[9];
	static int[] dwarf = new int[7];
	static boolean isFound;
	static boolean[] isSelected = new boolean[9];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<9;i++) {
			nine[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
		
		for(int i = 0; i<7;i++) {
			sb.append(dwarf[i]+ "\n");
		}
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start) {

		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i<7;i++) {
				sum += dwarf[i];
			}
			if(sum == 100) {
				isFound = true;
			}
			return;
		}
		
		for(int i =start; i<9;i++) {
			if(isFound) break;
			if(isSelected[i]) continue;
			isSelected[i] = true;
			dwarf[start] = nine[i];
			combination(cnt +1, start +1);
			isSelected[i] = false;
			if(isFound) break;
		}
	}
}
