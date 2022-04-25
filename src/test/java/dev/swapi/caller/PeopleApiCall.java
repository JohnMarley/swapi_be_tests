package dev.swapi.caller;

import dev.swapi.endpoints.Endpoints;
import dev.swapi.model.PersonDTO;
import io.restassured.response.Response;

import java.util.Map;

public class PeopleApiCall extends BaseApiCall {

    public PersonDTO getPersonById(String personId){
        Response response = makeGetCall(Endpoints.PERSON, Map.of(PERSON_ID, personId));
        response.then().statusCode(200);
        return response.as(PersonDTO.class);
    }
}
