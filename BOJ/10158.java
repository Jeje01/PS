/**
 * 개미 - S3
 * 수학
 * 13,016 kb
 * 84 ms
 * 
 * 실버인데 어려웠음
 * System.out.println 말고 StringBuilder 쓰니 통과 / 144 ms
 * 하지만 로직이 잘못된 것 -> x, y는 어차피 좌우, 상하를 반복함 : 따로 좌표를 구해주면 됨 / 84 ms
 * 
 * * 다른 사람 풀이 : 훨씬 간단함
 * if(sum/l%2==0) return sum%l;
 * else return l-sum%l;
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int w, h, p, q, t;
	static int[] dir = {1, 1};
	

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		w = Integer.parseInt(tokens.nextToken());
		h = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine(), " ");
		p = Integer.parseInt(tokens.nextToken());
		q = Integer.parseInt(tokens.nextToken());
		t = Integer.parseInt(input.readLine());
		int tmpT = t;
		if(p+t<=w) {
			p+=t;
		}else {
			tmpT-=w-p;
			tmpT%=(w*2);
			p=w;
			if(tmpT<=w) {
				p-=tmpT;
			}else {
				tmpT-=w;
				p=0;
				p+=tmpT;
			}
		}
		tmpT = t;
		if(q+t<=h) {
			q+=t;
		}else {
			tmpT-=h-q;
			tmpT%=(h*2);
			q=h;
			if(tmpT<=h) {
				q-=tmpT;

			}else {
				tmpT-=h;
				q=0;
				q+=tmpT;


			}
		}

		output.append(p).append(" ").append(q).append("\n");
		System.out.println(output.toString());
		
	}
}
