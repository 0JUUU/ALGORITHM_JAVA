import java.util.*;
import java.io.*;

/**
 * BOJ 16937 두 스티커
 * 2021.10.25
 * : 구현
 * @author 0JUUU
 *
 */
public class Main_BOJ_16937_두_스티커 {

	static class Sticker {
		int R, C;
		Sticker(int R, int C) {
			this.R = R;
			this.C = C;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		Sticker[] stickers = new Sticker[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			stickers[i] = new Sticker(R, C);
		}
		int maxWidth = 0;
		
		for(int i = 0; i<N; i++) {
			Sticker one = stickers[i];
			int maxLen = Math.max(one.R, one.C);
			int maxTotal = Math.max(H, W);
			if(maxLen > maxTotal) continue;
			for(int j = i+1; j<N; j++) {
				Sticker two = stickers[j];
				// 가로 기준으로 세로 합 (가로 : 최대 & 세로 합 : )
				int totalSum = (one.R * one.C) + (two.R * two.C);
				int max = Math.max(one.C, two.C);
				int sum = one.R + two.R;
				if(max <= H && sum <= W) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				} else if(max <= W && sum <= H) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				}
				
				max = Math.max(one.R, two.R);
				sum = one.C + two.C;
				if((max <= H && sum <= W) || (max <= W && sum <= H)) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				}
				
				max = Math.max(one.C, two.R);
				sum = one.R + two.C;
				if(max <= H && sum <= W) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				} else if(max <= W && sum <= H) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				}
				
				max = Math.max(one.R, two.C);
				sum = one.C + two.R;
				if((max <= H && sum <= W) || (max <= W && sum <= H)) {
					maxWidth = totalSum > maxWidth ? totalSum : maxWidth;
					continue;
				}
				// 세로 기준으로 가로 합 (세로 : 최대 & 가로 합 : )
			}
		}
		System.out.print(maxWidth);
	}
}
