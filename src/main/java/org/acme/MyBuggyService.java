package org.acme;

import io.smallrye.mutiny.Uni;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyBuggyService {

    WwwClient wwwClient;
    HttpServerRequest httpServerRequest;

    public MyBuggyService(@RestClient WwwClient wwwClient, HttpServerRequest httpServerRequest) {
        this.wwwClient = wwwClient;
        this.httpServerRequest = httpServerRequest;
    }

    public Uni<String> get() {
        return wwwClient.get()
                .map(s -> {
                    String buggy = httpServerRequest.getHeader("buggy");
                    return buggy + ' ' + s;
                });
    }
}
