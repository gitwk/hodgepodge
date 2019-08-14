# hodgepodge
系统基于SpringBoot2.1.6搭建

1、整合dubbo（2.7.3），采用nacos（1.1.3）作为dubbo服务的注册中心

2、基于nacos的配置管理功能，实现配置文件的动态获取

3、整合seata（0.7.1），用于实现基于AT模式的分布式的事务管理，实现代码的无侵入性

4、整合sentinel，用户实现服务降级限流等（待实现）
