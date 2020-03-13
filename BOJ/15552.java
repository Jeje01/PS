import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        int n = Integer.parseInt(br.readLine());
        int i;
        int[] arr = new int[n];
        for(i=0; i<n; i++) {
            String s = br.readLine();
            String[] sp = s.split(" ");
            bw.write(Integer.parseInt(sp[0]) + Integer.parseInt(sp[1])+"\n");
        }
        bw.flush();
        bw.close();
    }
}
