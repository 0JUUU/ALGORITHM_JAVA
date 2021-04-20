import java.util.*;

import com.sun.jndi.url.dns.dnsURLContext;

import java.io.*;

public class Main_BOJ_20055_컨베이어_벨트_위의_로봇 {
	static int N, K, zero;
	static LinkedList<Box> up = new LinkedList<>();
	static Deque<Box> down = new LinkedList<>();

	static class Box {
		int number;
		int weight;
		boolean isRobot;
		public Box(int number, int weight) {
			super();
			this.number = number;
			this.weight = weight;
			isRobot = false;
		}
		@Override
		public String toString() {
			return "Box [number=" + number + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N;i++) {
			int w = Integer.parseInt(st.nextToken());
			up.addLast(new Box(i, w));
		}
		
		for(int i = 0; i<N;i++) {
			int w = Integer.parseInt(st.nextToken());
			down.addFirst(new Box(i+N, w));
		}
		
		int count = 0;
		
		do {
			count++;
			// 1. 벨트 회전
			rotateBelt();
			
			// 2. 가장 먼저 올라간 로봇부터 회전하는 방향으로 이동 가능하면 이동
			moveRobot();
			
			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올림
			upRobot();
			
		} while(zero < K);
		System.out.println(count);
	}
	
	private static void upRobot() {
		if(up.peekFirst().weight == 0 || up.peekFirst().isRobot) return;
		up.peekFirst().isRobot = true;
		
		if(up.peekFirst().weight != 0) {
			up.peekFirst().weight--;
		}
		if(up.peekFirst().weight == 0) zero++;
		return;
	}
	
	private static void moveRobot() {
		int len = up.size();
		for(int i = len -1; i>=0; i--) {
			Box cur = up.get(i);
			if(!cur.isRobot) continue;
			if(i == len-1) {
				up.get(i).isRobot = false; continue;
			}
			if(up.get(i+1).weight != 0 && 
					!up.get(i+1).isRobot) {
				up.get(i).isRobot = false;
				up.get(i+1).weight -= 1;
				up.get(i+1).isRobot = true;
				if(up.get(i+1).number == up.peekLast().number) {
					up.get(i+1).isRobot = false;
				}
				if(up.get(i+1).weight == 0) zero++;
			}
		}
	}
	
	
	private static void rotateBelt() {
		down.addLast(up.pollLast());
		up.addFirst(down.pollFirst());
		up.peekLast().isRobot = false;
	}
	

}
