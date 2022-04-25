package dev.swapi.utils;

import dev.swapi.caller.StarShipsApiCall;
import dev.swapi.model.PersonDTO;
import dev.swapi.model.StarshipDTO;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StarShipsUtils {

    private StarShipsApiCall starShipsApiCall = new StarShipsApiCall();

    private static final Pattern STARSHIPS_ID_PATTERN = Pattern.compile("/starships/(\\d+)/");

    private String getShipIdFromUrl(String url){
        Matcher matcher = STARSHIPS_ID_PATTERN.matcher(url);
        return matcher.find() ? matcher.group(1) : null;
    }

    public List<StarshipDTO> getStarShips(PersonDTO character){
        return character
                .getStarships()
                .stream()
                .map(this::getShipIdFromUrl)
                .map(id -> starShipsApiCall.getStarShipById(id))
                .collect(Collectors.toList());
    }
}
