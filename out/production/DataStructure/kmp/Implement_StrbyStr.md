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
    
```aidl


```

- Best Solution -> KMP
    - O(n)







