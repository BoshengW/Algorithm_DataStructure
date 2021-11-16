## 数学基本算法
### 快速幂

### 分解质因数

### 位操作除法
- 利用二进制化来将除法转化为加减法
```
// Time Complexity Convert N operation into logN -> binarize
public int divide(int dividend, int divisor) {
    // convert division into sum of binary
    // Math.abs只能-2^31==0边界条件需要明确
    // 下界 / (-1) 会变0
    if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
    boolean sign = (dividend>0) ^ (divisor>0);
    
    long dd = Math.abs((long) dividend);
    long dr = Math.abs((long) divisor);
    if(dd<dr) return 0;
    // find the max binary
    long bin = dr;
    int digit = 0;
    while(bin<dd) {
        bin = bin<<1; // divisor * 2 without multiplication
        digit++;
    }
    // current bin should be > dd
    // 必须用long存结果如果res = -2^31 -> 在累加时会越界 
    long res = 0;
    while(dd>0 && bin>0) {
        if(dd>=bin) {
            dd-=bin;
            res += Math.pow(2, digit);
        }
        digit--;
        bin>>=1; // bin = bin/2 without divison  
    }
    int a = (int) res;
    return sign? -a: a;
}
```