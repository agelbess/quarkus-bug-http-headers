package org.acme;

import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MyResource {

    @Inject
    MyService myService;

    @Inject
    MyBuggyService myBuggyService;

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> get() {
        return myService.get();
    }

    @GET
    @Path("/buggyGet")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getBuggy() {
        return myBuggyService.get();
    }
}
