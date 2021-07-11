# Set
## Introdution
Set注重独一无二,该体系集合可以知道某物是否已经存在于集合中,不会存储重复的元素。Set的实现类在面试中常用的是：HashSet 与 TreeSet

### HashSet
- 无重复数据
- 可以有空数据
- 数据无序

```aidl
Set<String> set = new HashSet<>();
for (int i = 1; i < 6; i ++) {
set.add(i + "");
}
set.add("1"); //不会重复写入数据
set.add(null);//可以写入空数据
Iterator<String> iter = set.iterator();
while (iter.hasNext()) {
system.out.print(iter.next() + " ");//数据无序
}// 输出(无序)为 3 4 1 5 null 2
```

### TreeSet
- 无重复数据
- 不能有空数据
- 数据有序
```aidl
Set<String> set = new TreeSet<>();
for (int i = 1; i < 6; i ++) {
set.add(i + "");
}
set.add("1"); //不会重复写入数据
//set.add(null);//不可以写入空数据
Iterator<String> iter = set.iterator();
while (iter.hasNext()) {
system.out.print(iter.next() + " ");//数据有序
}// 输出(有序)为 1 2 3 4 5
```




