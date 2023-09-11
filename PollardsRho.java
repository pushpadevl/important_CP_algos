import java.util.*;
import java.io.*;

public class PollardsRho{
    public static void main(String[] args){
        int N = 2206637;
        findFactor(N);
    }
    static void findFactor(int N){
        int a=2;

        boolean factorFound=false;

        int x1=a; int x2=a;
        //for(;!factorFound; a++){
            if(gcd(a,N)!=1) {}//continue;
            else{
                x1 = fun(x1,N);
                x2 = fun(fun(x2,N),N);
                int gg = gcd(abs(x2-x1),N);
                while(gg==1){
                    System.out.printf("%d %d\n", x1, x2);
                    x1 = fun(x1,N);
                    x2 = fun(fun(x2,N),N);
                    gg = gcd(abs(x2-x1),N);
                }
                System.out.printf("%d %d\nGCD=%d", x1, x2,gg);
                
            }
        //}
    }
    static int fun(int x, int N){
        long y = (long)x;

        return (int)((y*y+1L)%(long)N);
    }
    static int abs(int a){
        if(a<0) return -a;
        else return a;
    }
    static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
}