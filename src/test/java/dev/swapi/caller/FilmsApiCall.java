package dev.swapi.caller;

import dev.swapi.endpoints.Endpoints;
import dev.swapi.model.FilmDTO;
import dev.swapi.model.FilmsDTO;
import io.restassured.response.Response;

import java.util.Map;

public class FilmsApiCall extends BaseApiCall {

    public FilmsDTO getFilms(){
        Response response = makeGetCall(Endpoints.FILMS, null);
        response.then().statusCode(200);
        return response.as(FilmsDTO.class);
    }
}
