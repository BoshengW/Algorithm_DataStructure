### 二进制转化

#### 针对问题
- 0/1选择组合问题

- 模板
```
- 数组 index 0~n-1

// i范围 [0, 11111..1]
for(int i=0; i<(1<<n); i++) {
    // j对i每一位扫描如果 ==1 加入
    for(int j=0; j<n; j++) {
        if(i&(1<<j)!=0) <do something>
    }
}

```