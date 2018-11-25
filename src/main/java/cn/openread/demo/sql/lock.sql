https://dev.mysql.com/doc/refman/5.7/en/innodb-locking- reads.html

SELECT... LOCK IN SHARE MODE

    在读取的任何行上设置共享模式锁定。其他会话可以读取行，但在事务提交之前无法修改它们。
    如果这些行中的任何行已被另一个尚未提交的事务更改，则查询将等待该事务结束，然后使用最新值。

SELECT... FOR
UPDATE

    对于搜索遇到的索引记录，锁定行和任何关联的索引条目，就像您UPDATE为这些行发出
    语句一样。阻止其他事务更新这些行，执行SELECT... LOCK IN SHARE MODE或从某些事务隔离级别读取数据。
    一致性读取将忽略在读取视图中存在的记录上设置的任何锁定。
    （旧版本的记录无法锁定;
它们是通过在记录的内存副本上应用撤消日志来重建的 。）

死锁例子 https://dev.mysql.com/doc/refman/5.7/en/innodb-deadlock-example.html


深入理解SELECT... LOCK IN SHARE MODE和SELECT... FOR UPDATE
    https://segmentfault.com/q/1010000008724925/a - 1020000008728908

    通过对比，

lock in share mode适用于两张表存在业务关系时的一致性要求，
适合多个表的一致性保障  例如下单业务：先下单，再扣库存

for update适用于操作同一张表时的一致性要求。
适合单个表的一致性保障