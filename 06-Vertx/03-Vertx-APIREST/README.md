# Vertx HelloWorld

A simple HelloWorld in Vertx.
In this example, we add the configuration of the vertx server port

## 1. Support configuration

## 1.1 Create the config file

Create a config file in main/conf/my-application-conf.json

```JSON
{
  "http.port" : 8082
}
``` 

## 1.2 Support the config in vertx start

```java
public void start(Future<Void> fut) {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first " +
                            "Vert.x 3 application</h1>");
                })
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }
``` 

## 2. Compile the project

```shell
$ mvn clean compile
```

## 3. Test the project

```shell
mvn clean test
```

## 4. Package the application

To create the package .jar of the application, execute:s

```shell
mvn clean package
```

## 5. Execute the application

Èxecute the application, passing the configuration as -conf parameter 

```shell
java -jar target/my-first-app-1.0-SNAPSHOT-fat.jar -conf src/main/conf/my-application-conf.json
```

And try in the browser:

```url
http://localhost:8082
```