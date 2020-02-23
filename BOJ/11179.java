import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp=0, i, ans=0, pro=1;
		ArrayList<Integer> list = new ArrayList<>();
		while(true) {
			tmp=n%2;
			list.add(tmp);
			n-=tmp;
			n/=2;
			if(n==0)
				break;
		}
		for(i=0; i<list.size(); i++) {
			ans+=pro*list.get(list.size()-i-1);
			pro*=2;
		}
		 System.out.println(ans);
	}
}
