import java.util.*;	// 자바 유틸리티패키지의 모든 클래스를 import한다
import java.io.*; // 자바 io패키지의 모든 클래스를 import한다.

public class Main_BOJ_20361_일우는_야바위꾼 {	
	public static void main(String[] args) throws Exception {	// 메인함수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();		// 출력을 위한 StringBuilder
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // N, X, K를 입력받음
		int N = Integer.parseInt(st.nextToken()); int X = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken()); // N, X, K 할당
			
		for(int k = 0; k<K;k++) {	// 컵의 위치를 맞바꾸는 횟수만큼 돌릴 for문
			st = new StringTokenizer(br.readLine());	// 두 컵의 위치 A, B 입력
			int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());	// A, B 할당
				
			if(X == A || X == B) // 바꿀 컵의 위치와 간식이 들어있는 종이컵이 일치하다면
				X = X==A? B:A;	 // 간식이 들어있는 종이컵이 움직인다는 얘기이므로 그 반대의 값을 대입한다.	
		} // end for k
		
		System.out.print(X);	// StringBuilder를 출력한다
	}	// main
}	
