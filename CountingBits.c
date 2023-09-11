#include <stdio.h>

void countBits(unsigned int x){
    unsigned int m[5];
    m[0] = 0x55555555;
    m[1] = 0x33333333;
    m[2] = 0x0f0f0f0f;
    m[3] = 0x00ff00ff;
    m[4] = 0xffffffff;
    int k=1;
    for(int i=0;i<5;i++){
        printf("%b\n",x);
        x = (x & m[i]) + ((x >> k) & m[i]);
        printf("%b\n\n",m[i]);
        k*=2;
    }
    
    printf("%b\n\n",x);

}
void main(){
   unsigned int x;
    
    while(1){
    
        scanf("%u",&x);
        
        unsigned int m[5];
        m[0] = 0x55555555;
        m[1] = 0x33333333;
        m[2] = 0x0f0f0f0f;
        m[3] = 0x00ff00ff;
        m[4] = 0xffffffff;
        int k=1;
        for(int i=0;i<5;i++){
            printf("%b\n",x);
            x = (x & m[i]) + ((x >> k) & m[i]);
            printf("%b\n\n",m[i]);
            k*=2;
        }
        
        printf("%b\n\n",x);

    }

}
// 10111100011000110111111011111111