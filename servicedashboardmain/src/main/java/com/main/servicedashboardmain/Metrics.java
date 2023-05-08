package com.main.servicedashboardmain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metrics {
    @JsonProperty("http.server.requests")
    private HttpServerRequests httpServerRequests;

    public HttpServerRequests getHttpServerRequests() {
        return httpServerRequests;
    }

    public void setHttpServerRequests(HttpServerRequests httpServerRequests) {
        this.httpServerRequests = httpServerRequests;
    }

}