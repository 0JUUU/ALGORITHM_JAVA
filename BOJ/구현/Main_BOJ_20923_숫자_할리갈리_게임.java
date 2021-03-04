import java.util.*;
import java.io.*;

/**
 * BOJ 20923 숫자 할리갈리 게임
 * 2021.03.04 
 * : 1. 순서가 굉장히 중요한 문제였음
 * 			if(mCount == M) {
				if(dodo.size() == suyeon.size()) whoWin = 0;
				else {
					whoWin = dodo.size() > suyeon.size() ? 1 : 2;
				}
				return;
			}
	: 이것의 위치를 종료조건에 넣었더니 
	2 2
	2 3
	1 4
	라는 테스트케이스를 dosu라고 출력함 원래 정답은 su임
 * @author 0JUUU
 *
 */
public class Main_BOJ_20923_숫자_할리갈리_게임 {
	static int N, M, mCount = 1, count;
	static Deque<Integer> dodo = new LinkedList<Integer>();
	static Deque<Integer> suyeon = new LinkedList<Integer>();
	static Deque<Integer> groundD = new LinkedList<Integer>();
	static Deque<Integer> groundS = new LinkedList<Integer>();
	static boolean isDodo = true;
	static int whoWin = 0;		// 0 : 무승부  1 : 도도  2 : 수연
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			dodo.addLast(Integer.parseInt(st.nextToken()));
			suyeon.addLast(Integer.parseInt(st.nextToken()));
		}
		
		gameStart();
		switch(whoWin) {
			case 0: 
				System.out.println("dosu"); break;
			case 1:
				System.out.println("do"); break;
			case 2: 
				System.out.println("su"); break;
		}
	}
	
	private static void gameStart() {
		while(true) {
			if(isDodo) {			// 카드 제출
				groundD.addFirst(dodo.pollLast());
				isDodo = false;
			} else {
				groundS.addFirst(suyeon.pollLast());
				isDodo = true;
			}
			
			if(dodo.size() == 0) {				// 게임이 끝나는 시점
				whoWin = 2;
				return;
			} else if(suyeon.size() == 0) {
				whoWin = 1;
				return;
			} 
			
			// 게임 진행
			if((!groundD.isEmpty() && groundD.peekFirst() == 5) || 
					(!groundS.isEmpty() && groundS.peekFirst() == 5)) {	// 도도가 종
				while(!groundS.isEmpty()) {
					dodo.addFirst(groundS.pollLast());
				}
				while(!groundD.isEmpty()) {
					dodo.addFirst(groundD.pollLast());
				}
			} else if(!groundD.isEmpty() && !groundS.isEmpty()
					&& (groundD.peekFirst() + groundS.peekFirst() == 5)) {	// 수연이가 종
				while(!groundD.isEmpty()) {
					suyeon.addFirst(groundD.pollLast());
				}
				while(!groundS.isEmpty()) {
					suyeon.addFirst(groundS.pollLast());
				}
			}
			
			if(mCount == M) {
				if(dodo.size() == suyeon.size()) whoWin = 0;
				else {
					whoWin = dodo.size() > suyeon.size() ? 1 : 2;
				}
				return;
			}
			mCount++;
		}
	}
}
