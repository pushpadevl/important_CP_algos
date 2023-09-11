#include<stdio.h>
#define PRINT2INTS(a,b) printf("%d %d\n", a, b);
    
int isqrt(unsigned x);
int main(){
    unsigned x;
    scanf("%u",&x);
    int sr = isqrt(x);
    printf("%d\n",sr);
}
int isqrt(unsigned x){
    unsigned x1;
    int s, g0, g1;

    if(x<=1) return x;      // x=290 = 1 0010 0010

    s=1;
    x1 = x-1;               // x1=289= 1 0010 0001

    if(x1 > 65535) {s = s+8; x1 = x1 >> 16;}
    if(x1 > 255) {s = s+4; x1 = x1 >> 8;}   // s=5, x1 = 1
    if(x1 > 15) {s = s+2; x1 = x1 >> 4;}    // 
    if(x1 > 3) {s = s+1;}                   // 
    
    printf("%u %d\n", x1, s);
    g0 = 1<<s;                              // g0 = 32
    g1 = (g0 + (x >> s)) >> 1;              // g1 = 20 = (32 + (290/32))/2 = 41/2
    PRINT2INTS(g0,g1);
    while(g1 < g0){                         //  (g0,g1) = (8,5) 
        g0 = g1;                            //  (g0,g1) = (5,5)
        g1 = (g0 + (x/g0)) >> 1;
        PRINT2INTS(g0,g1);                  
    }
    return g0;
}