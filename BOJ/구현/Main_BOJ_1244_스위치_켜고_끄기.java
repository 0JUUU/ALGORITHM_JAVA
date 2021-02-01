import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int count = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] light = new int[count+1];
		for(int c =1;c<=count;c++) {
			light[c] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		
		for(int s = 0;s<student;s++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex =  Integer.parseInt(st.nextToken());
			int num =  Integer.parseInt(st.nextToken());
			
			if(sex == 1) {	// 학생 : 남자
				for(int i = 1;i<=count;i++) {
					if(i % num == 0) 
						light[i] = light[i] == 0 ? 1 : 0;	// 주어진 수의 배수일 경우 스위치를 반전
				}
			}
			else {	// 학생 : 여자
				int left_side = num;
				int right_side = num;
				while(light[left_side] == light[right_side]) {
					if(left_side <= 1) break;
					if(right_side >= count) break;
					if(light[--left_side] != light[++right_side]) {
						left_side++; right_side--; break;
					}
				}
				
				for(int i = left_side; i<=right_side;i++) {
					light[i] = light[i] == 0 ? 1 : 0;	// 주어진 수의 배수일 경우 스위치를 반전
				}
			}
		} // for-s : 학생들의 정보 입력 및 그에 따른 전구 변화
		
		for(int i = 1;i<=count;i++) {
			if(i % 20 == 0) bw.write(light[i] +"\n");  
			else bw.write(light[i] + " ");
		}
		
		bw.flush(); bw.close();
	} // main
}
