package com.userreview.model;

import java.util.List;

public class ApplicationProperties{
    private List<App> applications;

    public void setApplications(List<App> applications){
        this.applications = applications;
    }

    public List<App> getApplications() {
        return this.applications;
    }
    
}