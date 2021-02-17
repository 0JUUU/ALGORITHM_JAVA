import java.util.*;
import java.io.*;

/**
 * BOJ 15686 치킨 배달
 * 2021.02.17
 * : 1. 임시 최종 치킨집들을 조합으로 구함 => 임시 최종 치킨집들과 각 집과의 최소거리(치킨거리)를 구하고 임시 도시의 치킨 거리를 구함 -> 모든 조합을 해 본 후 가장 최소값을 구함
 * : 2. 치킨거리를 구할 때, bfs를 이용해서 풀려고했음 --> 이것을 그냥 좌표값을 비교하면 간단한게 해걸할 수 있음 (이러한 사고를 가지도록 노력할 것)
 * @author 0JUUU
 *
 */
public class Main_BOJ_15686_치킨_배달 {
	static int N, M, minCity;
	static int[][] city, chickenHouse;
	static ArrayList<int[]> chickenList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		minCity = Integer.MAX_VALUE;
		city = new int[N][N];
		chickenHouse = new int[M][2];
		int chicken = 0;
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 2) {
					chicken++;
					chickenList.add(new int[] {i,j});
				}
			}
		}
	
		if(chicken == M) {
			for(int i = 0; i<M;i++) {
				chickenHouse[i] = chickenList.get(i);
			}
			minCity = getDistance();
		}
		else {
			combination(0,0);
		}
		System.out.println(minCity);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == M) {
			minCity = minCity > getDistance()? getDistance():minCity;
			return;
		}
		for(int i = start, size = chickenList.size(); i<size;i++) {
			chickenHouse[cnt] = chickenList.get(i);
			combination(cnt+1, i+1);
		}
	}
	
	static int getDistance() {
		int minHouse, sum = 0;
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(city[i][j] != 1) continue;
				minHouse = Integer.MAX_VALUE;
				for(int c = 0; c<M;c++) {
					int value = Math.abs(chickenHouse[c][0] - i) + Math.abs(chickenHouse[c][1]-j);
					minHouse = minHouse> value ? value : minHouse;
				}
				sum+= minHouse;
			}
		}
		return sum;
	}
}
