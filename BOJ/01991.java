/**
 * 트리 순회 - S1
 * 트리, 재귀
 * 130,36 kb
 * 92 ms
 * 
 * preorder, inorder, postorder
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] node;
	static int N;
	static Node[] nodes = new Node[26];
	
	static class Node{
		int root;
		int left;
		int right;
		
		public Node(int root, int left, int right) {
			super();
			this.root = root;
			this.left = left;
			this.right = right;
		}
		
		
		
	}
	
	static void preorder(int n) {
		if(n==-1) return;
		output.append((char)(n+'A'));
		preorder(nodes[n].left);
		preorder(nodes[n].right);
	}
	
	static void inorder(int n) {
		if(n==-1) return;
		inorder(nodes[n].left);
		output.append((char)(n+'A'));
		inorder(nodes[n].right);
	}
	
	static void postorder(int n) {
		if(n==-1) return;
		postorder(nodes[n].left);
		postorder(nodes[n].right);
		output.append((char)(n+'A'));

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		node = new int[3];
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<3; j++) {
				char tmp = tokens.nextToken().charAt(0);
				if(tmp>='A' && tmp<='Z') {
					node[j] = tmp-'A';
				}else {
					node[j] = -1;
				}
			}
			nodes[node[0]] = new Node(node[0], node[1], node[2]);
		}
		preorder(0);
		output.append("\n");
		
		inorder(0);
		output.append("\n");
		
		postorder(0);
		output.append("\n");
		
		System.out.println(output.toString());
		
	}
}
