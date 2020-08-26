/**
 * 배열 돌리기 4 - G4
 * 구현, 브루트포스
 * 185,352 kb
 * 932 ms
 * 
 * 회전 부분 비효율적 - 수정 필요
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] map;
	static int[][] tmp;
	static int[][] initial;
	static int N, M, K, r, c, s;
	static int answer = Integer.MAX_VALUE;
	static String[] rotates;
	
	static int[][] deepCopy(int[][] original){
		int[][] result = new int[original.length][original[0].length];
		for(int i=0; i<original.length; i++ ) {
			System.arraycopy(original[i], 0, result[i], 0, original[i].length);
		}
		return result;
	}
	
	static void permutation(int n, int r, int[] nums, boolean[] visited) {
		if(r==nums.length) {

			for(int i=0; i<initial.length; i++) {
				for(int j=0; j<initial[0].length; j++) {
					map[i][j] = initial[i][j];
				}
			}
			rotateMap(nums);
			return;
		}
		for(int i=0; i<nums.length; ++i) {
			if(visited[i]) continue;
			nums[n] = i;
			visited[i] = true;
			permutation(n+1, r+1, nums, visited);
			visited[i] = false;
			
		}
		
	}
	
	static void rotateMap(int[] order) {
		for(int k=0; k<K; k++) {
			String[] line = rotates[order[k]].split(" ");
			r = Integer.parseInt(line[0]);
			c = Integer.parseInt(line[1]);
			s = Integer.parseInt(line[2]);
			int size = s*2+1;
			
			// 옮길 부분 -> tmp
			tmp = new int[size][size];
			for(int i=r-s; i<=r+s; i++) {
				for(int j=c-s; j<=c+s; j++) {
					tmp[i-r+s][j-c+s] = map[i][j];
				}
			}
			// tmp에서 회전 후 원래 배열로
			for(int i=0; i<s; i++) {
				// size-i*2 : 한 줄 길이
				// i+size-i*2-1 : 마지막 인덱스
				int[][] next = new int[(size-i*2-1)*4][2];
				next[0] = new int[]{i, i};
				int idx = 1;
				// 윗줄
				for(int j=i+1; j<size-i; j++) {
					next[idx][0] = i;
					next[idx++][1] = j;
				}
				// 오른쪽
				for(int j=i+1; j<size-i; j++) {
					next[idx][0] = j;
					next[idx++][1] = size-i-1;
				}
				int last = (size-1-i*2)*2;
				for(int j=last-1; j>0; j--) {
					next[idx][0] = next[j][1];
					next[idx++][1] = next[j][0];
				}
				
				for(int j=0; j<next.length; j++) {
					int[] curPos = next[j];
					int[] nextPos = next[(j+1)%next.length];
					map[nextPos[0]+r-s][nextPos[1]+c-s]=tmp[curPos[0]][curPos[1]];
		
				}

			}

		}

		
		for(int i=1; i<map.length; i++) {
			int sum=0;
			for(int j=1; j<map[0].length; j++) {
				sum+=map[i][j];
			}
			answer = Math.min(answer, sum);

		}

	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N+1][M+1];
		initial = new int[N+1][M+1];
		for(int i=1; i<map.length; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=1; j<map[0].length; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				initial[i][j] = map[i][j];
			}
		}

		String line = "";
		rotates = new String[K];
		for(int k=0; k<K; k++) {
			line = input.readLine();
			tokens = new StringTokenizer(line);
			r = Integer.parseInt(tokens.nextToken());
			c = Integer.parseInt(tokens.nextToken());
			s = Integer.parseInt(tokens.nextToken());
			rotates[k] = r+" "+c+" "+s; 
			
		}
		
		permutation(0, 0, new int[K], new boolean[K]);
		System.out.println(answer);

	}

}
