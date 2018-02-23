package com.springboot.demo;

/**
 * Created by chenhe on 2018/2/23.
 */
public class DemoRequest {
    private String serviceName;
    private String apiVersion = "1.0";
    private String requestData;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }
}
