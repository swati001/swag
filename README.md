---
description: Created this readMe by using Gitbook app.
---

# Spring Boot + swagger + Actuator + Prometheus

## Spring Boot 2.x and Swagger

Swagger provides a very nice and clean documentation representation of your APIs developed. This helps business people to get to know all your API endpints and their relevant request and response details to be required by the endpoints. 

We need to simply add the dependency of swagger from springfox in your project:

```
$ Include the dependency of swagger in pom/gradle,
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```



## Spring Boot 2.x and Actuator 

Spring Boot provides multiple dependecies and one the dependency is Actuator. Actuator basically, provides features which can helps in creating components for health dashboard of your App/APIs etc. 

Here is an example of using actuator for a Spring Boot API development application :

```
$ Include the dependency of actuator in pom/gradle,
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Add these lines in your application.properties:



{% hint style="info" %}


management.endpoints.web.exposure.include=\*

management.endpoint.metrics.enabled=true
{% endhint %}

Now when we run our app then we can see all the endpoints of actuator, like actuator/info, actuator/metric, actuator/env, actuator/logger, actuator/health etc.

## Prometheus

```
$ Include the dependency of actuator in pom/gradle,
<dependency>
	<groupId>io.prometheus</groupId>
	<artifactId>simpleclient</artifactId>
	<version>0.4.0</version>
</dependency>
<dependency>
	<groupId>io.prometheus</groupId>
	<artifactId>simpleclient_spring_boot</artifactId>
	<version>0.4.0</version>
</dependency>
```

Add these lines in your application.properties:

{% hint style="info" %}


management.endpoints.prometheus.enabled=true

management.metrics.export.prometheus.enabled=true
{% endhint %}

Now on running the application, we can see there is another endpoint actuator/prometheus and hitting that endpoint, we can see the metrics, data is the actual metrics collected from the application.

