 /*
     * 상호의 배틀필드
     * 시뮬레이션
     * 19948kb
     * 125ms
     */
     
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;


class Solution
{
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int posR=-1, posC=-1, H, W;
	static char[][] map;
	public static void moveTo(int code) {
		int r=posR, c=posC;
		char tank = 0;
		switch(code) {
      case 0: //상
        r=posR-1;
        tank='^';
        break;
      case 1: //하
        r=posR+1;
        tank='v';
        break;
      case 2: //좌
        c=posC-1;
        tank='<';
        break;
      case 3: //우
        c=posC+1;
        tank='>';
        break;
		}
		if(r>=0 && r<H && c>=0 && c<W) {
			if(map[r][c]=='.') {
				map[posR][posC] = '.';
				posR = r; posC = c;
				map[posR][posC] = tank;
			}else {
				map[posR][posC] = tank;
			}
		}else{
             map[posR][posC] = tank;
        }
		return;
	}
	public static void shoot() {
		int dr = 0, dc = 0, r = posR, c = posC;
		switch(map[posR][posC]) {
      case '^':
        dr--;
        break;
      case 'v':
        dr++;
        break;
      case '<':
        dc--;
        break;
      case '>':
        dc++;
        break;
		}
		while(true) {
			int nr = r+dr;
			int nc = c+dc;
			if(nr>=0 && nr<H && nc>=0 && nc<W) {
				if(map[nr][nc]=='#')
					break;
				else if(map[nr][nc]=='*') {
					map[nr][nc]='.';
					break;
				}else if(map[nr][nc]=='.' || map[nr][nc]=='-'){
					r=nr; c=nc;
				}else {
					break;
				}
			}else {
				break;
			}
			
		}
	}
	public static void main(String args[]) throws Exception, NumberFormatException, IOException
	{
		int T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
			H = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				String str = input.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='^' || map[i][j]=='<' || map[i][j]=='v' || map[i][j]=='>') {
						posR = i; posC = j;
					}
				}
			}
			int N = Integer.parseInt(input.readLine());
			String orders = input.readLine();
			for(int i=0; i<N; i++) {
				char order = orders.charAt(i);
				switch(order) {
					case 'U':
						moveTo(0);
						break;
					case 'D':
						moveTo(1);
						break;						
					case 'L':
						moveTo(2);
						break;
					case 'R':
						moveTo(3);
						break;
					case 'S':
						shoot();
						break;
				}
			}
			output.append("#").append(t).append(" ");
			for(char[] row: map) {
				for(char a: row) {
					output.append(a);
				}
				output.append("\n");
			}
			
		}
		System.out.println(output.toString());
    }
}
