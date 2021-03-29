import java.util.*;	// util 패키지의 모든 것 import
import java.io.*;	// io 패키지의 모든 것 import	


/**
 * BOJ 2629 양팔저울
 * 2021.03.29
 * : ArrayList를 이용하여 풀었음 --> DP의 배낭문제와 비슷한 느낌으로 접근
 * @author 0JUUU
 *
 */

public class Main_BOJ_2629_양팔저울 { 
	public static void main(String[] args) throws Exception {	// main 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 입력받기 위해 해당 라인 작성
		StringBuilder sb = new StringBuilder();			// 출력 속도를 높이기 위해 사용
	
		int chuNum = Integer.parseInt(br.readLine());	// 추의 개수
		int maxWeight = 0;								// 추가 만들 수 있는 최대 무게
		int[] chus = new int[chuNum];					// 각 추의 무게를 담을 int[]
		
		StringTokenizer st = new StringTokenizer(br.readLine());	// 각 추의 무게를 입력받기 위해 사용
		for(int i = 0; i<chuNum;i++) {		// 추의 개수만큼 for문 실행
			chus[i] = Integer.parseInt(st.nextToken());		// 각 추의 무게를 저장
			maxWeight += chus[i];		// 추가 만들 수 있는 최대 무게를 계산
		}	// end for
	
		int[] avail = new int[maxWeight+1];	// 가능한 무게를 담을 배열 저장
		ArrayList<Integer> cal = new ArrayList<>();		// 현재까지 저장된 무게와 현재 저장할 추의 무게를 조합해서 만들 수 있는 추의 무게 저장할 ArrayList
		for(int i = 0; i<chuNum;i++) {		// 추의 개수만큼 for문을 돈다
			int w = chus[i];				// 입력된 추의 무게를 저장하는 w 변수
			if(i == 0) avail[w] = 1;		// 첫번째로 들어오는 값이라면 자기 자신만 가능하므로 
			else {
				for(int j = 1; j<maxWeight;j++) {
					if(avail[j] != 0) {
						int sub = Math.abs(j - w);
						if(!cal.contains(sub)) cal.add(sub);
						int sum = j + w;
						if(!cal.contains(sum)) cal.add(sum);
					}
				}
				if(!cal.contains(w)) cal.add(w);
				
				for(int j = 0; j<cal.size();j++) {
					avail[cal.get(j)] = 1;
				}
			}
		}
		
		avail[maxWeight] = 1;			// 최대 무게는 모두 다 더하면 되는 것이므로 무조건 생성 가능
		// 각각의 무게에 대한 Y/N을 결정
		int ballNum = Integer.parseInt(br.readLine());		// 구슬의 개수
		st = new StringTokenizer(br.readLine());		// 확인할 구슬의 무게를 입력받기 위해 사용
		for(int i = 0; i<ballNum;i++) {		// 확인할 구슬의 개수만큼 for문을 돌린다
			int weight = Integer.parseInt(st.nextToken());	// 확인할 구슬의 무게를 저장할 변수
			if(weight > maxWeight) sb.append("N ");		// 최대 무게보다 무거운 경우는 불가능하므로 N 출력
			else {
				if(avail[weight] == 0) sb.append("N ");	// 만들 수 없는 무게라면 N 출력
				else sb.append("Y ");			// 만들 수 있는 무게면 Y 출력
			}	// end else
		}	// end for
		System.out.println(sb); 	// StringBuilder에 저장된 내용 출력
		
	} // end main
	
}
