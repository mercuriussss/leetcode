package com.cjl.sword;

public class Solution_14_II {
    public int cuttingRope(int n) {
        if(n <= 3){
            return n-1;
        }
        int a = n/3;
        int b = n%3;
        long res = 1L;
        for (int i = 1; i < a; i++) {
            res = (res*3)%1000000007;
        }

        if(b == 0){
            res = (res*3)%1000000007;
        }else if(b == 1){
            res = (res*4)%1000000007;
        }else{
            res = (res*6)%1000000007;
        }
        return (int)res;
    }
}
