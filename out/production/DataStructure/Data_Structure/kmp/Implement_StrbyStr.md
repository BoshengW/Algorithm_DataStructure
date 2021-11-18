## Find a SubString inside a String

- Solution 1(Traversal + String.substring()) (not recommend)
    - O(n^2)
```
for(int i in [0, len(string) - len(target)]) {
    check -> substring(string, i, i+len(target)) == target
}

```
- Solution 2 Rabin-Krap
    - O(n)
    - encoding hashcode for all possible substring candidate 
        - if hashcode equal: check substring with target
    

- Best Solution -> KMP
    - O(n)
    
```
暴力解法
S[N] 长串
P[M] 短串

for(int i=1; i<n; i++) {
    
    bool flag
    for(int j=1; j<=m; j++) {
    }
}
```

```
KMP解法
String P;
String S;
int[] next = new int[P.length()+1];
for(int i=1, j=0; i<=m; i++) {
    
}
```







