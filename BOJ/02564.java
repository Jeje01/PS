/**
 * 경비원 - S1
 * 구현, case work, Ad hoc
 * 130,60 kb
 * 80 ms
 * 
 * 1234 -> 북서남동이 아니라 북남서동
 * index, 방향 주의하기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int C, R, N, pos[][], guardDir, guardDis, sum;

	static int[] getPos(int d, int a) {
		int[] res = new int[2];
		switch(d) {
		case 1:
			res[0] = 0;
			res[1] = a;
			break;
		case 2:
			res[0] = R;
			res[1] = a;
			break;
		case 3:
			res[0] = a;
			res[1] = 0;
			break;
		case 4:
			res[0] = a;
			res[1] = C;
			break;
		}
		return res;
	}
	
	static int getDis(int n) {
		int[] next = pos[n];
		int dis = 0;
		if(next[0]+guardDir==3 || next[0]+guardDir==7) {
			if(next[0]==1 || next[0]==2) {
				dis = next[1]+guardDis;
				dis = Math.min(dis, 2*C-dis);
				dis += R;
			}else {
				dis = next[1]+guardDis;
				dis = Math.min(dis, 2*R-dis);
				dis += C;
			}
		}else {
			int[] posA = getPos(next[0], next[1]);
			int[] posG = getPos(guardDir, guardDis);
			dis = Math.abs(posA[0]-posG[0])+Math.abs(posA[1]-posG[1]);
		}
		return dis;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(input.readLine());
		pos = new int[N][2];
		
		for(int i=0; i<N+1; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int d = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			if(i<N) {
				pos[i][0] = d;
				pos[i][1] = a;				
			}else {
				guardDir = d;
				guardDis = a;
			}
		}
		for(int i=0; i<pos.length; i++) {
			sum+=getDis(i);
		}
		output.append(sum);
		System.out.println(output.toString());
		
	}
}
