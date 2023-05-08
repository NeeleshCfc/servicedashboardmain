package com.main.servicedashboardmain;

public class ResponseObject {
    private String name;
    private int responseTime;
    private int requestCount;
    private String responseColour;
    private String responseStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getRequestCount(){
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public String getColour(){return responseColour;}
    public void setColour(String colour) {this.responseColour = colour;
    }

    public void setStatus(String status) {this.responseStatus = status;
    }
    public String getResponseStatus(){return responseStatus;}

}

