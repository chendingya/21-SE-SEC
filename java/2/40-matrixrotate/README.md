 # 矩阵旋转

从控制台输入一个m*n的矩阵，随后输入一个旋转角度t。输出该矩阵顺时针旋转t角度后的结果。

## 输入

第一行为两个数m n，为矩阵的大小。m,n均大于0

接下来m行，每行n个数。其中的第i行的第j列表示矩阵的第i行第j列的元素。

接下来一行有一个数t，为需要旋转的角度。t一定为90的倍数，且大于0

## 输出

m*n或n\*m个数，表示矩阵旋转的结果。

## 用例

输入：

```
3 4
1 2 3 4
5 6 7 8
9 10 11 12
90
```

输出：

```
9 5 1
10 6 2
11 7 3
12 8 4
```

输入：

```
3 4
1 2 3 4
5 6 7 8
9 10 11 12
180
```

输出：

```
12 11 10 9
8 7 6 5
4 3 2 1
```

# 