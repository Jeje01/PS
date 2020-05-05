// 첫 글자를 대문자로

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, j;
        char[][] ch = new char[n][];
        sc.nextLine();
        for(i=0; i<n; i++)
            ch[i]=sc.nextLine().toCharArray();
        for(i=0; i<n; i++) {
            for(j=0; j<ch[i].length; j++)
                if(j==0) {
                    if(ch[i][0]>='a'&&ch[i][0]<='z')
                        System.out.print((char)(ch[i][0]-32));
                    else
                        System.out.print(ch[i][0]);
                }
                else
                    System.out.print(ch[i][j]);
            System.out.println();
        }
    }
}
