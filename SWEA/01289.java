// 원재의 메모리 복구하기

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int previous = 0;
            String s = sc.next();
            int answer = 0;
            for(int j=0; j<s.length(); j++) {
                if((char)(previous+'0')!=s.charAt(j)) {
                    answer++;
                    previous=1-previous;
                }
            }
            System.out.printf("#%d %d\n", test_case, answer); 
        }
    }
}
