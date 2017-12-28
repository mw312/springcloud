本服务用例说明：
[集群]
1.服务注册中心集群实现高可用
2.通过启动参数-Dspring.profiles.active=host*加载对应的配置文件：
application-host1.yml，application-host2.yml，application-host3.yml
3.通过启动参数的变更（host1/host2/host3）可以启动多个注册中心的实例，他们之间互相注册。
4.当某个服务指定注册中心为集群的前提下，该服务会注册到集群里所有的注册中心，因此当集群上所有注册中心里的服务实例都有效的前提下，
多个Eureka server是对等的，它们都存有相同的信息，这样就可以通过服务器的冗余来增加注册中心的可靠性。
注册中心为集群，当某个服务[未启动]只指定集群中的一个注册中心而且该注册中心在挂掉的状态下，此服务在启动后不会同步到集群里的其他注册中心；
注册中心为集群，当某个服务[已启动]只指定集群中的一个注册中心，该注册中心如果挂掉后，不会同步到集群里的其他注册中心剔除该服务或者标记该服务为DOWN；
5.当注册中心全部都挂了，运行着的客户端之间依然可以通过原有的注册表进行调用；
6.某一注册中心A重启后，通过心跳机制连接此注册中心的客户端会继续注册进来，并同步给集群中的其他注册中心，其他注册中心B里无效的实例不会同步到A。
[安全]
1.注册中心的管理界面以及服务注册时，没有任何认证机制，安全性比较差，如果其它服务恶意注册一个同名服务，但是实现不同，可能就有风险了。
可以参考下面的配置改进：
先添加依赖：
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
然后在eureka server的application.yml中增加
security:
  basic:
    enabled: true
  user:
    name: admin     #用户名
    password: admin #密码
这样就添加了1个用户名及密码（注：其原理就是spring-security，熟悉spring-security的朋友，也可以改成把用户名/密码存储在数据库中)
启动后，再浏览eureka server就用输入用户名，密码了。
2.其它服务注册时，相应的defautZone也要改成类似以下格式：
defaultZone: http://admin:admin@host1:8760/eureka,http://admin:admin@host2:8770/eureka
