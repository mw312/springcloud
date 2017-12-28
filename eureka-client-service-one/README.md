本服务用例说明：
1.服务消费者
2.采用spring cloud config连接配置中心
3.多环境配置【本地测试时使用pro环境变量测试从配置中心获取配置】
4.pro环境下请求/refresh自动更新该服务的配置文件：
    4.1 添加依赖：增加了spring-boot-starter-actuator包，spring-boot-starter-actuator是一套监控的功能，
可以监控程序在运行时状态，其中就包括/refresh的功能。
    4.2 开启更新机制：需要给加载变量的类上面加载@RefreshScope，在客户端执行/refresh的时候就会更新此类下面的变量值。
    4.3 关闭安全认证：springboot 1.5.X 以上默认开通了安全认证，所以需要在配置文件application.properties添加以下配置：
    management.security.enabled=false
    4.4 以post请求的方式来访问http://localhost:8761/refresh 就会自动更新修改后的配置文件。
    [客户端服务可不用配置！理由：config server集成了actuator，可通过调用config server上的/bus/refresh实现总线上的所有客户端或者指定客户端的配置文件自动更新]
5.引入spring-cloud-starter-zipkin包，pro环境下实现服务调用链路追踪。
6.pro环境下连接到高可用服务注册中心。
