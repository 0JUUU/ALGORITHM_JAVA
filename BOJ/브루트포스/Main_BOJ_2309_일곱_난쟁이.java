import java.util.*;
import java.io.*;

/**
 * BOJ 2309. 일곱 난쟁이
 * 2021.02.05
 * 코딩방범대 브루트포스
 * : 1. 재귀 이용
 * : 2. for문 7개? V 
 * @param args
 */
public class Main_BOJ_2309_일곱_난쟁이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];
		int[] real = new int[7];
		for(int i = 0; i<9;i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarf);
		boolean isFind = false;
		for(int i = 0; i<9;i++) {
			for(int j = i+1; j<9;j++) {
				for(int k = j+1; k<9;k++) {
					for(int l = k +1;l<9;l++) {
						for(int m = l +1; m<9;m++) {
							for(int n = m+1;n<9;n++) {
								for(int o = n+1; o<9;o++) {
									if(dwarf[i] + dwarf[j] + dwarf[k] + dwarf[l]+ dwarf[m]+ dwarf[n]+ dwarf[o] == 100) {
										System.out.println(dwarf[i]);
										System.out.println(dwarf[j]);
										System.out.println(dwarf[k]);
										System.out.println(dwarf[l]);
										System.out.println(dwarf[m]);
										System.out.println(dwarf[n]);
										System.out.println(dwarf[o]);
										isFind = true;
										break;
									}
								} //o
								if(isFind) break;
							} // n
							if(isFind) break;
						} // m
						if(isFind) break;
					} // l
					if(isFind) break;
				} // k
				if(isFind) break;
			} // j
			if(isFind) break;
		} // i
	}
}
