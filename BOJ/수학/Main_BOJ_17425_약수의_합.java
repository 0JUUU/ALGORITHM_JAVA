import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ 17425. 약수의 합
 * 2021.02.02
 * 코딩방범대
 * : 17427과 같은 방법 --> 시간초과
 * 
 * @author 0JUUU
 */

public class Main_BOJ_17425_약수의_합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long[] g = new long[1000001];
		long[] f = new long[1000001];
		
		for(int i = 1;i<=1000000;i++) { 
			for(int j = 1; i * j <= 1000000; j++) {
				f[i*j] += i;
			}
		}
		for(int i = 1;i<=1000000;i++) {
			g[i] = g[i-1] + f[i];
		}

		for(int tc = 1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(g[N] + "\n");
			
		}
		bw.flush(); bw.close();
	}
}
