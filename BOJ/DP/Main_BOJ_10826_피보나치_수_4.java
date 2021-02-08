import java.util.*;
import java.io.*;
import java.math.*;

/**
 * BOJ 10826. 피보나치 수 4
 * 2021.02.08
 * SSAFY 스터디
 * : 1. long보다 훨씬 큰 수를 저장 가능한 BigInteger를 사용
 * [BigInteger]
 * : 1. new BigInteger
 * @author 0JUUU
 *
 */
public class Main_BOJ_10826_피보나치_수_4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger N = new BigInteger(br.readLine());
		BigInteger nplus = N.add(BigInteger.ONE);
		BigInteger[] fibo = new BigInteger[nplus.intValue()];
		
		if(N.intValue() < 2) {
			System.out.println(N.intValue());
			return;
		}
		fibo[0] = BigInteger.ZERO;
		fibo[1] = BigInteger.ONE;
		for(int i = 2; i<=N.intValue();i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
		System.out.println(fibo[N.intValue()]);
	}
}
