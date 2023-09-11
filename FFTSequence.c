#include<stdio.h>

#define uhd unsigned short int
uhd fftNext(uhd x, uhd m){

    x = x^m;
    while( x < m ){
        m >>= 1;
        x ^=m;
    }
    return x;
}
void main(){
    uhd x=0x0;
    int noOfBits;
    scanf("%d", &noOfBits);
    uhd m = 1<<(noOfBits-1);
    printf("m = %d\n",m);
    do{
        printf("%x ",x);       
        x = fftNext(x,m);
        printf(" -> %x\n",x);       
        
    }while(x!=0);
}
/*
0 8 4 c 2 a 6 e 1 9 5 d 3 b 7 f 0
*/