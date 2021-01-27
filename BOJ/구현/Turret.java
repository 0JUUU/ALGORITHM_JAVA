import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
/**
 * BOJ 1002. 터렛
 * 2021.01.27
 * SSAFY 스터디
 * 형을 무조건 통일
 * 변수명이 헷갈린다
 * 처음 풀이 --> 내접의 경우와 포함하는데 안만나는 경우가 포함이 안됐음 --> 코드가 복잡해서 아예 갈아엎을 것임
 * @author clleo
 *
 */
public class Turret {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0;tc<T;tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double d = Math.sqrt((Math.pow((x1-x2), 2) + Math.pow((y1-y2),2))); 
			int bigR = r1>r2? r1:r2;
			int smallR = r1>r2?r2:r1;
			
			if(d == smallR + bigR) bw.write("1\n");
			else if(d > smallR + bigR) bw.write("0\n");
			else 
			{
				if(bigR - smallR < d) bw.write("2\n");
				else if(d == 0 && bigR != smallR) bw.write("0\n");
				else if(d == 0 && bigR == smallR) bw.write("-1\n");
				else if(d < bigR) bw.write("0\n");
			}

		}
		bw.flush(); bw.close();
	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int T = Integer.parseInt(br.readLine());
//		
//		for(int tc = 0;tc<T;tc++) {
//			String s = br.readLine();
//			StringTokenizer st = new StringTokenizer(s);
//			int x1 = Integer.parseInt(st.nextToken());
//			int y1 = Integer.parseInt(st.nextToken());
//			int r1 = Integer.parseInt(st.nextToken());
//			int x2 = Integer.parseInt(st.nextToken());
//			int y2 = Integer.parseInt(st.nextToken());
//			int r2 = Integer.parseInt(st.nextToken());
//			
//			double pointlength = Math.sqrt((Math.pow((x1-x2), 2) + Math.pow((y1-y2),2))); 
//			int sumR = r1 + r2;
//			int subR = r1 > r2?r1-r2 : r2-r1;
//			int smallR = r1>r2?r2:r1;
//			if((double)sumR == pointlength) bw.write(1+"\n");	// 외접
//			else if((double)sumR < pointlength)  bw.write(0+"\n"); 	// 밖에서 안만나
//			else if((double)subR == 0 && pointlength == 0)  bw.write(-1+"\n");	// 동일
//			else if((double) sumR == ((double)subR + pointlength)) bw.write(1+"\n");	// 내접
//			else if((double) sumR >((double)subR + pointlength))  bw.write(0+"\n");	// 
//			else if(pointlength == 0 && subR != 0) bw.write(0+"\n");	// 점 동일 --> 반지름 안 같을 경우
//			else if(subR < pointlength && pointlength < sumR)  bw.write(2+"\n");	// 두점에서 만날 경우
//		}
//		bw.flush();
//		bw.close();
//	}
}
