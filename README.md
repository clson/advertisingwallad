# advertisingwallad(JAVA课程设计广告墙项目)
jdk版本 1.8

数据库版本 mysql5.5（由于mysql8.0的新特新，所以Driver要写成“com.mysql.cj.jdbc.Driver”
url:"jdbc:mysql://host_address:3306/db_name?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"）
如果按照原来的写法，那么Drvier会报警告，但不会报错，程序可以正常执行，但是url那里则会报错，程序退出）

数据库连接技术：jdbcTemplate 
JdbcTemplate针对数据查询提供了多个重载的模板方法,你可以根据需要选用不同的模板方法.如果你的查询很简单，仅仅是传入相应SQL或者相关参数，然后取得一个单一的结果，那么你可以选择如下一组便利的模板方法
优点：运行期：高效、内嵌Spring框架中、支持基于AOP的声明式事务
缺点：必须于Spring框架结合在一起使用、不支持数据库跨平台、默认没有缓存

使用需要导入五个jar包  
spring-beans-5.0.0.RELEASE.jar
spring-core-5.0.0.RELEASE.jar
spring-jdbc-5.0.0.RELEASE.jar
spring-tx-5.0.0.RELEASE.jar
commons-logging-1.2.jar

连接池：阿里巴巴的druid  需要导入druid.jar包 本项目导入的是druid-1.0.9.jar
druid为阿里巴巴的数据源，（数据库连接池），集合了c3p0、dbcp、proxool等连接池的优点，还加入了日志监控，有效的监控DB池连接和SQL的执行情况。

项目架构混乱无法描述
