/**
 * 미세먼지 안녕! - G5
 * 구현, 시뮬레이션
 * 35,924 kb
 * 460 ms
 * 
 * * 주의
 * 퍼지는 것이 다음 퍼질 값에 영향을 줄 수 있으므로 따로 저장한 후에 합쳐야 함
 * 회전 시에 회전 방향의 시작부터 회전하면 원래의 값이 없어지므로 끝부터 옮겨야 함
 * -1에서 나오는 자리에 0 넣어주기
 * 마지막에 전체 값 더할 때 -1 2개 -> +2 해주기
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, T, answer;
	static int[][] map;
	static int[][] tmp;
	static int[][] air;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		map = new int[R][C];
		air = new int[2][2];
		
		int idx = 0;
		for(int i=0; i<R; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j]==-1) {
					air[idx][0] = i;
					air[idx++][1] = j;
				}
			}
		}

		for(int t=1; t<=T; t++) { // 매 초마다
			tmp = new int[R][C];

			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					int subtract = 0;
					if(map[i][j]!=-1 && map[i][j]!=0) {
						for(int d=0; d<dirs.length; d++) {
							int nr = i+dirs[d][0];
							int nc = j+dirs[d][1];
							if(nr<0 || nr>=R || nc<0 || nc>=C || map[nr][nc]==-1) continue;
							tmp[nr][nc]+= map[i][j]/5;
							subtract++;
						}
						map[i][j]-=(map[i][j]/5)*subtract;
					}
				}
			}
			
			// tmp에 저장해놓은 퍼지는 값 map에 합치기
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j]+=tmp[i][j];
				}
			}

			// 공기청정기 순환

			// 위
			for(int i=air[0][0]-2; i>=0; i--) {
				map[i+1][0] = map[i][0];				
			}
			for(int i=air[0][1]+1; i<C; i++) {
				map[0][i-1] = map[0][i];				
			}
			for(int i=1; i<=air[0][0]; i++) {
				map[i-1][C-1] = map[i][C-1];
			}
			for(int i=C-2; i>air[0][1]; i--) {
				map[air[0][0]][i+1] = map[air[0][0]][i];
			}
			
			// 아래
			//시작열 위로
			for(int i=air[1][0]+2; i<=R-1; i++) {
				map[i-1][air[1][1]] = map[i][air[1][1]];
			}
			// 끝열 왼쪽으로
			for(int i=air[1][1]+1; i<C; i++) {
				map[R-1][i-1] = map[R-1][i];
			}
			for(int i=R-2; i>=air[1][0]; i--) {
				map[i+1][C-1] = map[i][C-1];
			}
			for(int i=C-2; i>air[1][1]; i--) {
				map[air[1][0]][i+1] = map[air[1][0]][i];
			}
			map[air[0][0]][air[0][1]+1] = 0;
			map[air[1][0]][air[1][1]+1] = 0;
			
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				answer+=map[i][j];
			}
		}
		answer+=2;
		output.append(answer);
		System.out.println(output.toString());
		
	}

}
