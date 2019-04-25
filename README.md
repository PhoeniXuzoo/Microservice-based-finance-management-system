# Microservice-based finance management system

This project is a microservice-based finance management system. You can use this system to manage data about income, expenses and finance product. And this system will use relevant data to create a statistic file which can help you manage wealth.

## Features

- SPA(Single page web application)
- Microservice-based
- Oauth2
- RESTful API
- Batch Upload and Batch Download
- Load Balancing
- Feign
- Hystrix

## Modules

1.**Discovery Service**

Port:8889

This module offers Service Discovery function. You can access localhost:8889 to accquire information about other instances, including name, port, status and so on. Every instance will register at localhost:8889/eureka and know the status of other instances at ，http://localhost:8889/serviceregistry/instance-status.

In this system, the first application started is Discovery Service.

2.**Config Service**

Port:9990

Config Service implements external configuration. For each module listed below, if you use

    spring.cloud.config.label= master
	spring.cloud.config.profile= dev
	spring.cloud.config.discovery.enabled=true
	spring.cloud.config.discovery.service-id= configservice

in bootstrap.properties, it will get some key parameters at [ConfigOnGithub](https://github.com/PhoeniXuzoo/Microservice-based-finance-management-system/tree/master/ConfigOnGithub). if the name of a application is A, then the name of configuration file has to be A-dev.properties.

3.**Oauth2 Service**

Port:8882

Oauth2 is a protocol which allows third-party applications to grant limited access to an HTTP service. Oauth2 Service implements functions of registration, login, and authority management. There is a key topic about authority management.

if Service A wants to access the resources which belongs to Service B, A has to accquire an access code from Oauth2 Service. Some details can be found at [Spring Cloud Security](https://spring.io/projects/spring-cloud-security) and [Oauth2](https://oauth.net/2)

4.**APIGateway**

5.**Account Service**

6.**Income Service**

7.**Expenses Service**

8.**Finance Product Service**

9.**Real Assets Service**

10.**Statistic Service**
