# Vertx Api REST

Example of API REST on Vertx - Implementing Database

## 1. Start the mongodb database

Go to database folder and execute:

```shell 
$ docker-compose up -d
```

This will start the mongo database at port 27017

## 2. Execute the application

```shell 
$ mvn clean package
$ ava -jar target/my-first-app-1.0-SNAPSHOT-fat.jar \
    -conf src/main/conf/my-application-conf.json
```

## 3. Test in the browser

You can test the application in the browser:

```url
http://localhost:8082/assets/index.html
``` 
