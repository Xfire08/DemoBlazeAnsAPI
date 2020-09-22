package testcases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Test
public class ApiTest {

    public void validateSpaceXResponseCode()
    {
        // I have clubbed 2-3 Test Here itseld insted of Creating seperated @Test Methods .

        //TC 1 - > Validate the Api Status Code is Correct
        RestAssured.baseURI = "https://api.spacexdata.com/v4/launches/latest";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        System.out.println("response Status Code is  " + response.getStatusCode());
        int resCode = response.getStatusCode();
        Assert.assertEquals(200,resCode);


        //TC 2 - > Validate the Api Contains a Specific String
        System.out.println("Response From API is " + response.asString());
        String responseInString = response.asString();
        responseInString.contains("This mission will launch the eleventh batch of operational Starlink satellites, which are expected to be version 1.0, from SLC-40, Cape Canaveral Air Force Station. It is the twelfth Starlink launch overall. The satellites will be delivered to low Earth orbit and will spend a few weeks maneuvering to their operational altitude of 550 km. The booster for this mission is expected to land on an ASDS.");

        //TC 3 - > Validate the Api Contains a Specific String
        JsonPath jsonPathEvaluator = response.jsonPath();
        boolean SucessNodeFromRunTime = jsonPathEvaluator.get("success");
        Assert.assertTrue(SucessNodeFromRunTime);


        //TC 4 - > Validate the Api response contains specific details for array
        String actual = jsonPathEvaluator.get("links.patch.small");
        String expected = "https://images2.imgbox.com/9a/96/nLppz9HW_o.png";
        Assert.assertEquals(actual,expected);




    }







}
