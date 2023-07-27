# 二进制读取

从一个二进制文件中读取其所有的字节，然后以字符串形式将其返回

需要完成FileReader类中的以下方法：

```java
public String readFile(String filePath) throws IOException;
```

该方法接受文件路径filePath作为参数，返回从文件中读取的字节数组转换成为的字符串。

## 用例

假如文件a中的字节数组对应的字符串为abc，则以下调用：

```java
FileReader fileReader=new FileReader();
System.out.println(fileReader.readFile("a"));
```

应该在控制台中输出：

```
abc
```



请不要改变目录的结构！否则可能会导致测试错误。