import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		int m = 0;
		String s;
    
		for(int a = 0; a<n; a++)
			str[a] = "";
		
    for(int i = 0 ; i<n; i++) {
			m = sc.nextInt();
			s = sc.next();
			for(int k = 0; k<s.length(); k++)
				for(int j = 0 ; j<m; j++) {
					str[i] += s.charAt(k);
				}
		}
		
    for(int l=0; l<n; l++) {
			System.out.println(str[l]);
		}
	}
}
