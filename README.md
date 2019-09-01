# transpiler-compare
Using different transpilers to implement a simple client that consumes an REST API.

# Backend

`./gradlew :backend:bootRun`

# GWT

This submodule creates the most pain.

## Gradle plugin

https://gwt-gradle-plugin.documentnode.io/setup-and-configuration/quickstart

## Compilation

Simply run `./gradlew :gwt:clean :gwt:compileGwt`

Should an error occur consider using Java 1.8.

## Running in IntelliJ

`./gradlew :gwt:clean :gwt:compileGwt :gwt:gwtSuperDev`

This starts a code server on port 9876.

Next, open `war/GWTDemo.html` in your browser.
