import java.util.*;	// 자바 유틸리티패키지의 모든 클래스를 import한다
import java.io.*; // 자바 io패키지의 모든 클래스를 import한다.

public class Main_BOJ_20299_3대_측정 {		
	public static void main(String[] args) throws Exception {	// 메인함수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력을 위한 BufferedReader 선언
		StringBuilder sb = new StringBuilder();		// 출력을 위한 StringBuilder
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // N, S, M을 입력받음
		int N = Integer.parseInt(st.nextToken()); int S = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); // N, S, M 할당
		int count = 0; // 가입 가능한 동아리 수를 저장할 변수
		int[] student = new int[3];	// 가입 신청한 동아리의 동아리원들의 능력치를 저장할 배열
		
		for(int n = 1; n<=N;n++) {	// 가입 신청한 동아리수 만큼 돌릴 for문
			int sum = 0;	// 가입 신청한 동아리의 전체 능력치를 저장할 변수
			boolean isLess = false;	// 가입 신청한 동아리의 전체 능력치나 개인의 능력치가 미달된 경우를 구별할 변수
			
			st = new StringTokenizer(br.readLine());	// 동아리 3인의 각각의 능력치 입력
			for(int i = 0; i<3;i++) {	// 동아리원들의 능력치를 배열에 할당하고, 기준치보다 넘는지 확인하기위한 for문
				student[i] = Integer.parseInt(st.nextToken());	// 입력받은 능력치를 개개인의 동아리원에게 할당	
				sum += student[i];	// 능력치의 합을 구함
				if(student[i] < M) isLess = true;	// 개개인의 능력치가 M보다 작다면, 동아리가 스마트클럽에 들 수 없다는 의미
			} // end for i
			if(sum < S) isLess = true;	// 전체 능력치가 S보다 작다면, 동아리가 스마트클럽에 들 수 없다는 의미
			
			if(!isLess) {		// 모든 조건(전체 능력치, 개인 능력치)을 통과했다면
				count++;		// 가입 가능한 동아리 수를 하나 증가
				for(int i = 0; i<3;i++) {	 // 가입 가능한 동아리원들의 개개인의 능력치를 저장하기 위해 돌리는 for문
					sb.append(student[i]+ " ");	// 스마트클럽에 가입된 학생들의 능력치를 출력하기 위해 StringBuilder에 공백을 포함하여 append
				} // end for i
			}	// end if
		}// end for n
		
		sb.insert(0, count+"\n");	// 스마트클럽에 가입한 동아리수를 출력하기 위해 "\n"과 함께 StringBuilder에 append
		System.out.print(sb);	// StringBuilder를 출력한다
	}	// main
}	