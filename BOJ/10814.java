/**
 * 나이순 정렬
 * 정렬 - Comparator
 * 48,424 kb
 * 724 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static String[][] ages;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		ages = new String[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				
				ages[i][j] = tokens.nextToken();
			}
		}
    
		Arrays.sort(ages, new Comparator<String[]>(){
			@Override
			public int compare(String[] o1, String[] o2) {
				if(!o1[0].equals(o2[0]))
					return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
				else
					return 0;
			}
		});
    
		for(String[] row: ages) {
			output.append(row[0]).append(" ").append(row[1]).append("\n");
		}
		System.out.println(output.toString());
	}

}
