union语法不支持，可改为OR查询（shardingjdbc连OR也不支持，所以建议使用shardingsphere）

用于分表的列在sql中不能为空，所以像insert之类的语句需要做下非空判断；

字段为空的时候插入主键有问题的issue已经解决
https://github.com/apache/shardingsphere/issues/2897

连表的时候的BUG
https://www.cnblogs.com/coolgame/p/12124142.html

limit的问题, 假如Limit 5,1
一个表很多数据，一个表没数据，查出来也是1条，BUG应该修复了

好像主键生成的类一定要用SPI的方式，直接用引用类都会失败
1.在resource建立包 META-INF，再在包下建立包services，结果就是META-INF.services
2.在包下建立文件org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator，内容是你的主键生成的类的相对路径

未测

sql中含有now()函数调用，程序报错
解决方案：service生成时间戳传给dao，sql中直接参数替换，剔除now函数(看来是组件还不支持这个函数解析)
因为表里面没搞时间字段，改天测，函数是支持的，测了find_in_set("haha",name)
limit的问题
http://www.voidcn.com/article/p-sbsuhaaa-bya.html
https://www.cnblogs.com/lhh-north/p/11140940.html
好的解决方案
https://zhouzhixiang.blog.csdn.net/article/details/104853956

sqlmap中LONGVARCHER字段不能使用，会报序列化异常，可改为VARCHAR类型；

报错缺少antlr4-runtime
解决方案：加入依赖

druid 要使用spring 版本而不是spring boot 版本
https://www.cnblogs.com/Mr-lin66/p/13267699.html
