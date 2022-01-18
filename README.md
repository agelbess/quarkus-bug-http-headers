# quarkus-bug-http-headers

There seems to be a bug in the quarkus reactive implementation when the HttpServerRequest is initialized after calling a
rest client.

To reproduce, I have created 2 service. 
* The first initializes the HttpServerRequest before calling the rest client.
* The second initialized the HttpServerRequest after calling the rest client.

To see this in action, just execute the tests in MyResourceTest.java

    mvn test
