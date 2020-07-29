/**
 * 햄버거 다이어트
 * 부분집합
 * 105,668 kb
 * 2,777 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int[][] arr;
	static int answer, L;
	
	static void powerset() {
		for(int i=0; i<(1<<arr.length); i++) {
			int sumCalories = 0, sumScores = 0;
			List<Integer> list = new ArrayList<>();
			for(int j=0; j<arr.length; j++) {
				if((i & (1<<j))>0) {
					list.add(j);
				}
			}
			if(list.size()!=0) {
				for(int j=0; j<list.size(); j++) {
					sumCalories+=arr[list.get(j)][1];
				}
				if(sumCalories<=L) {
					for(int j=0; j<list.size(); j++) {
						sumScores+=arr[list.get(j)][0];
					}
				}
				answer = answer > sumScores? answer : sumScores;
			}			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for (int t=1; t<=T; t++){
			StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
			answer = 0;
			int N = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			arr = new int[N][2];
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine(), " ");
				for(int j=0; j<2; j++) {
					arr[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			powerset();
			output.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(output.toString());
	}

}
 
