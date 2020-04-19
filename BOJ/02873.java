// Greedy - 롤러코스터

import java.util.Scanner;

public class Main {
    public static class pos{
        int r, c;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        pos minPos = new pos();
        int[][] arr = new int[r][c];
        int i, j, min=1000;
        if(r%2!=0 || c%2!=0) {
            for (i = 0; i < r; i++) {
                for (j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
        } else{
            for(i=0; i<r; i++){
                for(j=0; j<c; j++){
                    arr[i][j] = sc.nextInt();
                    if((i+j)%2!=0){
                        if(min>arr[i][j]){
                            min = arr[i][j];
                            minPos.r = i;
                            minPos.c = j;
                        }
                    }
                }
            }
        }
        if(r%2!=0){
            for(i=0; i<r; i++){
                for(j=0; j<c-1; j++){
                    if(i%2==0){
                        System.out.print("R");
                    }else{
                        System.out.print("L");
                    }
                }
                if(i!=r-1)
                    System.out.print("D");
            }
        }else if(c%2!=0){
            for(i=0; i<c; i++){
                for(j=0; j<r-1; j++){
                    if(i%2==0){
                        System.out.print("D");
                    }else{
                        System.out.print("U");
                    }
                }
                if(i!=c-1)
                    System.out.print("R");
            }
        }else if(r%2==0 && c%2==0){
            int tmp = minPos.r%2==0? minPos.r : minPos.r-1;
            for(i=0; i<tmp; i++){
                for(j=0; j<c-1; j++){
                    if(i%2==0){
                        System.out.print("R");
                    }
                    else {
                        System.out.print("L");
                    }
                }
                System.out.print("D");
            }
            //중간 두줄
            for(i=0; i<minPos.c; i++){
                if(i%2==0){
                    System.out.print("DR");
                }else{
                    System.out.print("UR");
                }
            }
            if(minPos.c!=c-1) System.out.print("R");
            for(i=minPos.c+1; i<c-1; i++){
                if(i%2!=0){
                    System.out.print("DR");
                }else{
                    System.out.print("UR");
                }
            }
            if(minPos.c!=c-1) System.out.print("D");
            if(tmp+1!=r-1) System.out.print("D");
            for(i=tmp+2; i<r; i++){
                for(j=0; j<c-1; j++){
                    if(i%2==0){
                        System.out.print("L");
                    }
                    else {
                        System.out.print("R");
                    }
                }
                if(i!=r-1)
                    System.out.print("D");
            }
        }
    }
}
