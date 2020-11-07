package io.quarkiverse.cxf.transport;

import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.inject.spi.CDI;

public class CxfHandler  implements Handler<RoutingContext>{
    private static final String ALLOWED_METHODS = "GET, OPTIONS";
    private static final String CONTENT_TYPE = "text/plain; charset=UTF-8";

    @Override
    public void handle(RoutingContext event) {
        UndertowConduit undertowConduit = CDI.current().select(UndertowConduit.class).get();
        UndertowDestination undertowDestination = CDI.current().select(UndertowDestination.class).get();


        HttpServerRequest request = event.request();
        HttpServerResponse response = event.response();
        if (request.method().equals(HttpMethod.OPTIONS)) {
            response.headers().set(HttpHeaders.ALLOW, ALLOWED_METHODS);
        } else if (request.method().equals(HttpMethod.GET)) {
            response.headers().set(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE);
            response.end(Buffer.buffer(schemaString));
        } else {
            response.setStatusCode(405).end();
        }
    }
}

