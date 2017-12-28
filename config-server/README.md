本服务用例说明：
1.开启rabbitmq实现异步消息推送
2.配置文件变更后
if 当未配置actuator接口安全验证或者management.security.enabled=false时通过POST方法调用:
http://${配置中心IP}:${server.port}/bus/refresh
if 当management.security.enabled=true开启actuator接口安全验证时则通过POST方法调用:
http://${security.user.name}:${security.user.password}@${配置中心IP}:${management.port}/${management.context-path}/bus/refresh
触发配置中心重新从github拉取配置文件，然后通过消息以及事件的形式实现所有连接配置中心的客户端节点的配置文件的同步更新
[快捷post命令：curl -X POST http://admin:admin@localhost:11111/admin/bus/refresh]
3.通过/bus/refresh?destination=serviceAppName来刷新消息总线上指定的微服务实例的配置文件[serviceAppName指的是各个微服务的ApplicationContext ID]
4.如果注册中心采用基础安全校验，服务注册时需要指定用户名和密码，例如：defaultZone: http://admin:admin@localhost:8760/eureka/