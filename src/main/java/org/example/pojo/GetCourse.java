package org.example.pojo;

public class GetCourse {
    private String url;
    private String services;
    private String expertise;
    private org.example.pojo.Courses Courses;
    private String instructor;
    private String linkedIn;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }
    public String getExpertise() {
        return expertise;
    }
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public org.example.pojo.Courses getCourses() {
        return Courses;
    }
    public void setCourses(org.example.pojo.Courses courses) {
        Courses = courses;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public String getLinkedIn() {
        return linkedIn;
    }
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }
}
