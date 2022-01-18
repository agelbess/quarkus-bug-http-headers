package org.acme;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(configKey = "WwwClient")
public interface WwwClient {
    @GET
    @Path("/")
    Uni<String> get();
}
