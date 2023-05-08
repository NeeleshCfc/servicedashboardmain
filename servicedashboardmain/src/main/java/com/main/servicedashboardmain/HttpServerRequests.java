package com.main.servicedashboardmain;


import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpServerRequests {
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("time")
    private Double time;
    @JsonProperty("uri")
    private String uri;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}


