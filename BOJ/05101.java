import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> list = new ArrayList<>();
        while(true){
            String[] sp = br.readLine().split(" ");
            int a = Integer.parseInt(sp[0]);
            int b = Integer.parseInt(sp[1]);
            int c = Integer.parseInt(sp[2]);
            if(a==0 && b==0 && c==0) break;
            if((c-a)%b==0)
                if((c-a)*b<0)
                    list.add("X");
                else
                    list.add(((c-a)/b+1)+"");
            else
                list.add("X");
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals("X"))
                bw.write("X\n");
            else
                bw.write(list.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
