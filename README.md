# rest-book

Hi,
I'm Mariano, 
I developed this example project as a first approach to the Quarkus framework.

This project uses Quarkus, the Supersonic Subatomic Java Framework.
Furthermore, the following extensions have been added to the pom:
-quarkus-resteasy-reactive: to create the rest api of this application using the annotations provided by the JAX-RS specification that this extension adds to the application.
-quarkus-resteasy-reactive-jsonb: to obtain the binding from Java object to JSON (provided as output of some of the APIs) obtained thanks to JSON-B.
-quarkus-arc: to get the features of the CDI specification.
-quarkus-junit5 and rest-assured: to use the annotations of the respective frameworks and create a test class for the implemented methods.

This project is the result of the exercise based on Antonio Goncalves's Udemy course.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rest-book-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
