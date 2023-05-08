package com.main.servicedashboardmain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Duration {
    @JsonProperty("0.5")
    private double percentile50;
    @JsonProperty("0.95")
    private double percentile95;

    public double getPercentile50() {
        return percentile50;
    }

    public void setPercent(double percentile50){
    this.percentile50=percentile50;}

    public double getPercentile95(){
        return percentile95;
    }

    public void setPercentile95(double percentile95){
        this.percentile95=percentile95;
    }
}
