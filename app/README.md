
Use `demo-group` to illustrate the idea. 

in 1.0-SNAPSHOT, it contains directly code for class:
`com.google.cloud.workflows.v1.LocationName`

in 2.0-SNAPSHOT, it does not contain Java class code directly, instead it has dependency on `proto-google-cloud-workflows-v1`

1. test with demo-group 1.0-SNAPSHOT

```asciidoc
[INFO] com.example:app:jar:1.0-SNAPSHOT
[INFO] +- com.example:demo-group:jar:1.0-SNAPSHOT:compile
[INFO] \- com.example:library:jar:1.0-SNAPSHOT:compile
[INFO] |  \- com.example:demo-group:jar:1.0-SNAPSHOT:compile

```

run `mvn install` from project root.
then run the app
```commandline
╭─ ~/repos/test/demo/app 
╰─$ mvn exec:java -Dexec.mainClass="com.example.app.Main"    
```

expect console print
```asciidoc
Hello, World!
can access v1/LocationName directly
Class 'com.google.cloud.workflows.v1.LocationName' found in classpath
Yes! v1.LocationName is accessible
can access via library

```
2. change demo-group 2.0-SNAPSHOT

switch to the commented out part in pom.xml to exclude the Java class from compiling, change pom dependencies and use `2.0-SNAPSHOT` for version. 

run `mvn install` from `demo-group` folder

3. in app/pom.xml, update `demo-group` version only
```xml
    <dependency>
      <groupId>com.example</groupId>
      <artifactId>demo-group</artifactId>
      <version>2.0-SNAPSHOT</version>
    </dependency>
```
here is the new dependency tree
```asciidoc
[INFO] com.example:app:jar:1.0-SNAPSHOT
[INFO] +- com.example:demo-group:jar:2.0-SNAPSHOT:compile
[INFO] |  +- com.google.api.grpc:proto-google-cloud-workflows-v1:jar:2.60.0:compile
[INFO] |  |  +- com.google.protobuf:protobuf-java:jar:3.25.5:compile
[INFO] |  |  +- com.google.api.grpc:proto-google-common-protos:jar:2.54.1:compile
[INFO] |  |  +- com.google.api:api-common:jar:2.46.1:compile
[INFO] |  |  +- com.google.auto.value:auto-value-annotations:jar:1.11.0:compile
[INFO] |  |  +- com.google.code.findbugs:jsr305:jar:3.0.2:compile
[INFO] |  |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] |  |  +- com.google.errorprone:error_prone_annotations:jar:2.36.0:compile
[INFO] |  |  +- com.google.j2objc:j2objc-annotations:jar:3.0.0:compile
[INFO] |  |  +- com.google.guava:guava:jar:33.4.0-jre:compile
[INFO] |  |  +- com.google.guava:failureaccess:jar:1.0.2:compile
[INFO] |  |  +- com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:compile
[INFO] |  |  \- org.checkerframework:checker-qual:jar:3.49.0:compile
[INFO] |  \- com.google.api.grpc:proto-google-cloud-workflows-v1beta:jar:0.66.0:compile
[INFO] \- com.example:library:jar:1.0-SNAPSHOT:compile
```
run `mvn exec:java -Dexec.mainClass="com.example.app.Main"`

```asciidoc
Hello, World!
can access v1/LocationName directly
Class 'com.google.cloud.workflows.v1.LocationName' found in classpath
Yes! v1.LocationName is accessible
can access via library
```
4. app is configured with maven-dependency-plugin. it gives warnings in this case

run ` mvn dependency:analyze`, expect:
```
[WARNING] Used undeclared dependencies found:
[WARNING]    com.google.api.grpc:proto-google-cloud-workflows-v1:jar:2.60.0:compile
```