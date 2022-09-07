# springcloud2021
自学springcloud的仓库

参考视频:https://www.bilibili.com/video/BV18E411x7eT

自制脑图：https://www.processon.com/view/link/602f2f0c7d9c081db9a6ac85

# 模块说明
cloud-api-commons:为公共包

cloud-consumer-order80：客户端消费者模块  
cloud-provider-payment8001、cloud-provider-payment8002：（Eureka）服务端提供者模块  
cloud-eureka-server7001、cloud-eureka-server7002：Eureka注册中心

cloud-comsumerzk-order80/cloud-provider-payment8004:为Zookeeper的消费者和提供者

cloud-consumercs-order80/cloud-provider-payment8006:为Consul的消费者和提供者

cloud-consumer-feign-order80:为OpenFeign的消费者

cloud-consumer-feign-hystrix-order80/cloud-provider-hystrix-payment8001：为Hystrix的消费者和服务提供者

cloud-consumer-hystrix-dashboard9001：为Hystrix服务监控

cloud-gateway-gateway9527:为GateWay网关服务

cloud-config-center3344/cloud-config-client3355:为config的客户端和服务端，springcloud-config-center为配置仓库，连接github/gitee

cloud-config-center3344/cloud-config-client3355/cloud-config-client3366/springcloud-config-center:为Config+Bus做配置中心+消息总线