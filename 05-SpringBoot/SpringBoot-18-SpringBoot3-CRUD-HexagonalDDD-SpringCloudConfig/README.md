# Spring Boot 3 API REST CRUD using Hexagonal & DDD approach && Spring Cloud Config

A spring boot 3 API REST CRUD implemented using Hexagonal Architecture & Domain Driven Design Approach.

We have also used the __Lombok library__ to avoid having to program the getters, setters and the parameterized constructor.

And we have also used __Spring Cloud Config__ to manage the centralized Configuration.

## 1. Go to H2 console

Go to this url

http://localhost:8080/h2-console/

Put the JDBC URL, name and password set in application.yml

## 2. Configuration to use spring cloud config to load the configuration

### 2.1 Using of a bootstrap.yml instead of application.yml

```yml
spring:
  config:
    # Load Config from Spring Cloud Config Remote Server
    import: http://localhost:8889/spring-crud-dev.yml
    # Load Config from local file
    # import: classpath:config.yml
# Logs of Spring Cloud Config
logging:
  level:
    org.springframework.cloud: DEBUG
```

We can choose how to load the config uncomenting the appropiate line.

Uncomment this to load config from Sprint Cloud Config remote Server.  

```yml
import: http://localhost:8889/spring-crud-dev.yml
```

Or uncomment this to load config from config.yml local file

```yml
import: classpath:config.yml
```

### 2.3 Spring cloud config Server Configuration

The Spring Cloud Config Server is mounted for testing purposes in the infra folder

There is a docker-compose.yml with this dockerization of the server:

```shell
version: '3.5'

services:

  springcloudconfig-lab:
    image: hyness/spring-cloud-config-server:3.0.4-jdk15
    container_name: springcloudconfig-lab
    restart: unless-stopped
    environment:
      - SPRING_CLOUD_CONFIG_SERVER_GIT_URI=git@github.com:diegopm2000-lab/lab-config-dev.git
    ports:
      - 8889:8888
    volumes:
      - ./springcfg_ssh_config/id_rsa:/root/.ssh/id_rsa:ro
      - ./springcfg_ssh_config/known_hosts:/root/.ssh/known_hosts:ro
```

Note: in the docker-compose.yml is set the SPRING_CLOUD_CONFIG_SERVER_GIT_URI with the value of the repository in github that will contain the configuration

And a folder named springcfg_ssh_config where it is mandatory to put the next files:

id_rsa: your private key to auth in github
known_hosts: a file needed to connect github
