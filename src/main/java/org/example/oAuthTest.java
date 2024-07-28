package org.example;

import io.restassured.path.json.JsonPath;
import org.example.pojo.Api;
import org.example.pojo.GetCourse;
import org.example.pojo.WebAutomation;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class oAuthTest {
    public static void main(String []args){
        String [] coursesTitles = {"Selenium Webdriver Java", "Cypress","Protractor"};
        String response =given().formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type","client_credentials")
                .formParams("scope","trust").when().log().all().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();

        System.out.println(response);

        JsonPath jsonpath  =new JsonPath(response);
        String accesstoken=jsonpath.getString("access_token");
        System.out.println(accesstoken);

        //returning java object of the class
        //deserilization
        GetCourse gc =given().queryParam("access_token",accesstoken).when()
                .log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
        System.out.println(gc.getLinkedIn());
        System.out.println((gc.getInstructor()));
        System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

        //iterating throught the all the courses
        List<Api> apiCourses= gc.getCourses().getApi();
        for ( int i =0;i<apiCourses.size();i++){
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")){
                System.out.println(apiCourses.get(i).getPrice());
            }
        }
        //get courses
        List<WebAutomation> wc=gc.getCourses().getWebAutomation();
        for (int i=0;i<wc.size();i++){
            System.out.println(wc.get(i).getCourseTitle());
        }

        //compre two array
        ArrayList <String> a =new ArrayList<String>();
        for( int i=0;i< wc.size();i++){
            a.add(wc.get(i).getCourseTitle());
        }
        List<String> expectedList = Arrays.asList(coursesTitles);
        Assert.assertTrue(a.equals(expectedList));

    }
}
