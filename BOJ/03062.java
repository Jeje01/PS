import java.util.Scanner;

public class Main {
	public static void ans(String a) {
		String tmp="";
		int i, sum, check=0;
		String str;
		for(i=0; i<a.length(); i++)
			tmp+=a.charAt(a.length()-1-i);
		sum=Integer.parseInt(a)+Integer.parseInt(tmp);
		str=String.valueOf(sum);
		for(i=0; i<str.length()/2; i++)
			if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
				check=1;
				break;
			}
		if(check==1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		int i;
		for(i=0; i<n; i++)
			arr[i] = sc.next();
		for(i=0; i<n; i++)
			ans(arr[i]);
	}	
}
