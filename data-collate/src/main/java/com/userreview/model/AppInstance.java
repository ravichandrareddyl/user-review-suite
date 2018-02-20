package com.userreview.model;

public class AppInstance {
    private String instanceName;
    private String dbClass;
    private String dbUrl;
    private String user;
    private String password;


    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setUser(String user){
        this.user = user;
    }
    public String getUser(){
        return this.user;
    }

    public void setDbUrl(String dbUrl){
        this.dbUrl = dbUrl;
    }
    public String getDbUrl(){
        return this.dbUrl;
    }

    public void setDbClass(String dbClass){
        this.dbClass = dbClass;
    }
    public String getDbClass(){
        return this.dbClass;
    }

    public void setInstanceName(String instanceName){
        this.instanceName = instanceName;
    }
    public String getInstanceName(){
        return this.instanceName;
    }
}