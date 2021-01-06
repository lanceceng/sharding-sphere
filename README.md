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


ShardingSphere 注意事项
1：数据修改不可修改分区键

2：在配置关联表的关联关系是数组不是字符串。

ShardingSphere 事务
本地事务
完全支持非跨库事务，例如：仅分表，或分库但是路由的结果在单库中。
完全支持因逻辑异常导致的跨库事务。例如：同一事务中，跨两个库更新。更新完毕后，抛出空指针，则两个库的内容都能回滚。
不支持因网络、硬件异常导致的跨库事务。例如：同一事务中，跨两个库更新，更新完毕后、未提交之前，第一个库宕机，则只有第二个库数据提交。
两阶段事务-XA
Java通过定义JTA接口实现了XA的模型，JTA接口里的ResourceManager需要数据库厂商提供XA的驱动实现，而TransactionManager则需要事务管理器的厂商实现，传统的事务管理器需要同应用服务器绑定，因此使用的成本很高。 而嵌入式的事务管器可以以jar包的形式提供服务，同ShardingSphere集成后，可保证分片后跨库事务强一致性。

功能
支持数据分片后的跨库XA事务
两阶段提交保证操作的原子性和数据的强一致性
服务宕机重启后，提交/回滚中的事务可自动恢复
SPI机制整合主流的XA事务管理器，默认Atomikos，可以选择使用Narayana和Bitronix
同时支持XA和非XA的连接池
提供spring-boot和namespace的接入端
不支持项
服务宕机后，在其它机器上恢复提交/回滚中的数据