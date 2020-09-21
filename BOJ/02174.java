/**
 * 로봇 시뮬레이션 - G5
 * 시뮬레이션
 * 13,112 kb
 * 92 ms
 * 
 * 간단한 시뮬레이션 문제로 보고 대충 읽고 풀었다가는 끝없는 디버깅을 하게 된다.
 * 
 * 우선, 좌표를 상하 뒤집어서 봐야한다.
 * 동서남북으로 이동할 때 북쪽이 (1, 0), 남쪽이 (-1, 0)이다.
 * 
 * 가로가 A, 세로가 B이기 때문에 행, 열을 뒤집어서 봐야한다.
 * 
 * 인덱스를 바로 사용하려고 행, 열의 0 자리를 비워뒀는데, 
 * 범위 나가는 걸 체크할 때 if(nr<=0)처럼 0을 포함해야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int A, B, N, M, map[][];
	static Robot[] robots;
	static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 북쪽부터 시계 방향 
	
	
	static class Robot{
		int r;
		int c;
		int dir;
		
		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
	
	static int rotate(int a, int d) { // d: 0이면 왼쪽, 1이면 오른쪽
		if(d==0) {
			return a==0? 3: a-1;
		}else {
			return (a+1)%4;
		}
	}
	
	static boolean move(int rob, char op, int dis) {
		boolean check = true;
		Robot robot = robots[rob];
		int curR = robot.r;
		int curC = robot.c;
		int curDir = robot.dir;
		switch(op) {
		case 'L':
			for(int i=1; i<=dis%4; i++) {
				curDir = rotate(curDir, 0);				
			}
			robots[rob].dir = curDir;
			break;
		case 'R':
			for(int i=1; i<=dis%4; i++) {
				curDir = rotate(curDir, 1);				
			}
			robots[rob].dir = curDir;
			break;
		case 'F':
			outerLoop: for(int i=1; i<=dis; i++) {
				map[curR][curC] = 0;
					int nr = curR+dirs[curDir][0];
					int nc = curC+dirs[curDir][1];
					if(nr<=0 || nr>=B+1 || nc<=0 || nc>=A+1) {
						output.append("Robot "+rob+" crashes into the wall");
						check = false;
						break outerLoop;
					}
					if(map[nr][nc]!=0) {
						output.append("Robot "+rob+" crashes into robot "+map[nr][nc]);
						check = false;
						break outerLoop;
					}
					curR = nr;
					curC = nc;
					map[curR][curC] = rob;
				}
			break;
		
		}
		if(op=='F' && check) {
			robot.r = curR;
			robot.c = curC;
			map[robot.r][robot.c] = rob;
		}
		return check;
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[B+1][A+1];
		robots = new Robot[N+1];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int c = Integer.parseInt(tokens.nextToken());
			int r = Integer.parseInt(tokens.nextToken());
			char dir = tokens.nextToken().charAt(0);
			int d=-1;
			switch(dir) {
			case 'N':
				d=0;
				break;
			case 'E':
				d=1;
				break;
			case 'S':
				d=2;
				break;
			case 'W':
				d=3;
				break;
			}
			map[r][c] = i;
			robots[i] = new Robot(r, c, d);
		}

		int i;
		for(i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int rob = Integer.parseInt(tokens.nextToken());
			char op = tokens.nextToken().charAt(0);
			int dis = Integer.parseInt(tokens.nextToken());
			boolean success = move(rob, op, dis);
			if(!success) break;
		}
		if(i==M) output.append("OK");	
		System.out.println(output.toString());
		
	}
}
