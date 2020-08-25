/**
 * 쿼드트리 - S1
 * Divide and Conquer
 * 13,348 kb
 * 84 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static boolean[][] map;
	static int N;
	
	static int checkElements(int rs, int re, int cs, int ce) {
		boolean first = map[rs][cs];
		boolean same = true;
		for(int i=rs; i<=re; i++) {
			for(int j=cs; j<=ce; j++) {
				if(first!=map[i][j]) {
					same = false;
					break;
				}
			}
		}
		if(same==false) {
			return -1;
		}else {
			if(first) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	
	static void explore(int rs, int re, int cs, int ce) {
		if(rs==re) {
			int tmp=0;
			if(map[rs][cs]) {
				tmp=1;
			}
			output.append(tmp);
			return;
		}
		int[][] district = {{rs, (rs+re)/2, cs, (cs+ce)/2},
				{rs, (rs+re)/2, (cs+ce)/2+1, ce},
				{(rs+re)/2+1, re, cs, (cs+ce)/2},
				{(rs+re)/2+1, re, (cs+ce)/2+1, ce}};
		for(int i=0; i<district.length; i++) {
			int res = checkElements(district[i][0], district[i][1], district[i][2], district[i][3]);
			if(res==-1) {
				output.append("(");
				explore(district[i][0], district[i][1], district[i][2], district[i][3]);
				output.append(")");
			}else {
				output.append(res);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = input.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)=='0'? false: true;
			}
		}
		int res = checkElements(0, N-1, 0, N-1);
		if(res!=-1) {
			output.append(res);
		}else {
			output.append("(");
			explore(0, N-1, 0, N-1);
			output.append(")");	
		}
		System.out.println(output.toString());
	}
	
	

}
