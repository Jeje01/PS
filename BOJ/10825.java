/**
 * 국영수 - S4
 * 정렬
 * 64,004 kb
 * 1,192 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        arr = new String[N][4];
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<4; j++){
                arr[i][j] = tokens.nextToken();
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1].equals(o2[1])){
                if(o1[2].equals(o2[2])){
                    if(o1[3].equals(o2[3])){
                        return o1[0].compareTo(o2[0]);
                    }else{
                        return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
                    }
                }else{
                    return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
                }
            }else{
                return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
            }
        });

        for(int i=0; i<N; i++){
            output.append(arr[i][0]+"\n");
        }
        System.out.println(output.toString());
    }

}
