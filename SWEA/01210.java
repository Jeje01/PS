// Ladder1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

class Solution
{
	static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}}; //좌, 우, 하
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int answer;
	static int[][] map;
  static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int t=1; t<=10; t++) {
            int n = Integer.parseInt(input.readLine());
            answer=-1;
			map = new int[100][100];
			for(int i=0; i<map.length; i++) {
				StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
				for(int j=0; j<map.length; j++) {
					map[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			for(int j=0; j<map.length; j++) {
				int r = 0, c = j;
				if(map[r][c]==0) continue;
				visited = new boolean[map.length][map.length];
				visited[r][c] = true;
				while(r!=map.length-1) {
					visited[r][c] = true;
					for(int i=0; i<3; i++) {
						int nr = r+dirs[i][0];
						int nc = c+dirs[i][1];
						if(nr>=0 && nr<map.length && nc>=0 && nc<map.length) {
							if(visited[nr][nc]==true) continue;
							if(map[nr][nc]!=0 && visited[nr][nc]==false) {
								r=nr; c=nc;
								break;
							}
						}
					}
                    if(map[r][c]==2) {
                        answer = j;
                        break;
                    }
				}
				
                if(answer!=-1) {
					break;
				}
			}
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output.toString());
	}
}
