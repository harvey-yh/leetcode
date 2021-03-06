#leetcode算法题 

## 位操作基础

| 符号 | 描述 | 运算规则 |  
|  ---   |  ---   |  ---  |  
| & | 与 | 两个位都为1时，结果才为1，其余为0|  
| l | 或 | 两个位都为0时，结果才为0，其余为1|  
| ^ | 异或 | 两个位相同为0，相异位1|  
| ~ | 取反 | 0变1， 1变0|  
| << | 左移 | 各二进制全部左移若干位，高位丢弃，低位补0|  
| \>> | 右移 |各二进制全部右移若干位，对无符号数，高位补0 ，有符号数，各编译器处理方法不一样，有的补符号位，有的补0|  

### 常用位操作小技巧
1. **判断奇偶**
> 只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a % 2 == 0)来判断a是不是偶数。

2. **交换两数**
``` java
int c = 1, d = 2; 
c ^= d; 
d ^= c; 
c ^= d;
```
3. **变换符号**
```
int a = -15, b = 15; 
System.out.println(~a + 1); 
System.out.println(~b + 1);
```

4. **求绝对值**
> 
因此先移位来取符号位，int i = a » 31;要注意如果a为正数，i等于0，为负数，i等于-1。然后对i进行判断——如果i等于0，直接返回。否之，返回~a+1。完整代码如下：

```
int i = a >> 31;   //取符号位
System.out.println(i == 0 ? a : (~a + 1));

优化后：（未使用任何判断表达式）

int j = a >> 31; 
System.out.println((a ^ j) - j);
```


5. **获得int型最大值** 
```
System.out.println((1 << 31) - 1);// 2147483647， 由于优先级关系，括号不可省略 
System.out.println(~(1 << 31));// 2147483647 
```

6. **获得int型最小值**
```
System.out.println(1 << 31); 
System.out.println(1 << -1);

```

7. **获得long类型的最大值**
```
System.out.println(((long)1 << 127) - 1);
```
