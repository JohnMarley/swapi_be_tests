package dev.swapi.caller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.collections4.MapUtils;


import java.util.Map;

import static io.restassured.RestAssured.given;

public abstract class BaseApiCall {

    private String host = RestAssured.baseURI;

    static final String PERSON_ID = "personId";
    static final String SHIP_ID = "shipId";



    protected Response makeGetCall(final String uri, Map<String, String> requestParameters){
        RequestSpecification requestSpecification = given();
        MapUtils.emptyIfNull(requestParameters).forEach(requestSpecification::pathParam);
        return requestSpecification
                .log()
                .uri()
                .log()
                .method()
                .get(host + uri);
    }
}
