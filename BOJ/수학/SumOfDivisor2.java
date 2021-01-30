import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 17427. 약수의 합2
 * 2021.01.28
 * 코딩방범대 - 수학
 * 
 * */

public class SumOfDivisor2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long ans = 0;
		for(int i = 1;i<=N;i++) {
			ans += (N/i) *i;
		}
		
		System.out.println(ans);
	}
}
