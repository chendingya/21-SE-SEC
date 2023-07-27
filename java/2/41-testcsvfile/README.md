# testCSVFile

某个记录员工信息的csv文件中有以下字段：

Last_name,First_name,Salary,Department,Employee_id

输入不同的命令，根据命令显示出特定的员工信息记录

命令可能有以下关键词：

select [fields] 输出表格中特定字段的列。fields如果包含多列，则以","隔开。fields为"*"，则输出所有列。保证field一定在表中存在

order by [field] 按照某字段进行降序排序。保证字段是数字形式

limit [n] 输出结果中的前n行

一行命令的格式为:

select [fields] {order by [field]} {limit [n]}

其中{}包含的内容是可选内容。

## 输入

从控制台输入一行命令，格式见上。

此外，main方法的参数args中的第一个元素为文件路径。

## 输出

以格式化的表格形式显示结果，间隔均匀（4个空格）。  
注意：标点符号均为英文标点符号。  

## 用例

假设csv文件中的数据如下：

```
Ling,Mai,55900,Research,1
Johnson,Jim,56500,Finance,2
Zarnecki,Sabrina,51500,Affair,3
```

输入：

```
select *
```

输出：

```
Last_name    First_name    Salary    Department    Employee_id
Ling    Mai    55900    Research    1
Johnson    Jim    56500    Finance    2
Zarnecki    Sabrina    51500    Affair    3
```

输入：

```
select Salary,Employee_id order by Salary
```

输出：

```
Salary    Employee_id
56500    2
55900    1
51500    3
```

输入：

```
select Salary,Employee_id order by Salary limit 2
```

输出：

```
Salary    Employee_id
56500    2
55900    1
```

