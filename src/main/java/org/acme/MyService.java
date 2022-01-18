package org.acme;

import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpServerRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {

    WwwClient wwwClient;
    HttpServerRequest httpServerRequest;

    public MyService(@RestClient WwwClient wwwClient, HttpServerRequest httpServerRequest) {
        this.wwwClient = wwwClient;
        this.httpServerRequest = httpServerRequest;
    }

    public Uni<String> get() {
        String buggy = httpServerRequest.getHeader("buggy");
        return wwwClient.get().map(s -> {
          return buggy + " " + s;
        });
    }
}
