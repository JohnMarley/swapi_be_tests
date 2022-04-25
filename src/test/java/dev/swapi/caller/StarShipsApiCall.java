package dev.swapi.caller;

import dev.swapi.endpoints.Endpoints;
import dev.swapi.model.StarshipDTO;
import io.restassured.response.Response;

import java.util.Map;

public class StarShipsApiCall extends BaseApiCall {

    public StarshipDTO getStarShipById(String starShipId){
        Response response = makeGetCall(Endpoints.STARSHIPS, Map.of(SHIP_ID, starShipId));
        response.then().statusCode(200);
        return response.as(StarshipDTO.class);
    }
}
