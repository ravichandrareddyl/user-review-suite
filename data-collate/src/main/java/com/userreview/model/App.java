package com.userreview.model;

import java.util.List;

public class App{
    
    private String name;
    private List<AppInstance> instances;
    private String query;

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    
    public List<AppInstance> getInstances() {
        return this.instances;
    }
    public void setIntances(List<AppInstance> instances){
        this.instances = instances;
    }
}