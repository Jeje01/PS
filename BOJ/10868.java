/**
 * 최솟값
 * Segment Tree
 * 57,496 kb
 * 620 ms
 * 참조 : https://bactoria.github.io/2019/03/14/%EC%84%B8%EA%B7%B8%EB%A8%BC%ED%8A%B8-%ED%8A%B8%EB%A6%AC-(%EA%B5%AC%EA%B0%84%ED%95%A9,-%EA%B5%AC%EA%B0%84%EA%B3%B1,-%EC%B5%9C%EC%86%8C%EA%B0%92,-%EC%B5%9C%EB%8C%80%EA%B0%92)/
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] arr, tree;
	static int[][] pos, dp;
	static int height, answer, nodes, N, M;
	
	static int getMin(int idx, int left, int right, int start, int end) {
		if(idx>=tree.length-1) return Integer.MAX_VALUE;
		if(right<start || left>end) return Integer.MAX_VALUE;
		else if(left>=start && right<=end) {
			return tree[idx]; 
		}
		int mid = (left+right)/2;
		return Math.min(getMin(idx*2, left, mid, start, end),getMin(idx*2+1, mid+1, right, start, end));
	}

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N+1];
		height = (int)Math.ceil(Math.log(N)/Math.log(2))+1;
		nodes = (int)Math.pow(2, height-1);
		tree = new int[nodes*2];
		Arrays.fill(tree, Integer.MAX_VALUE);
		pos = new int[M][2];
		// leaf node
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(input.readLine());
			tree[nodes+i] = tmp;
		}
		
		for(int i=height-2; i>=0; i--) { // 3, 2, 1, 0
			for(int j=(int)Math.pow(2,  i); j<Math.pow(2,  i+1); j++) {
				tree[j] = Math.min(tree[j*2], tree[j*2+1]);
			}
		}
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			answer = getMin(1, 1, (int)Math.pow(2, height-1), start, end);
			output.append(answer).append("\n");
		}
		System.out.println(output.toString());
	}

}
