package dev.swapi.utils;

import dev.swapi.caller.PeopleApiCall;
import dev.swapi.model.PersonDTO;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleUtils {

    private PeopleApiCall peopleApiCall = new PeopleApiCall();

    private static final Pattern PEOPLE_ID_PATTERN = Pattern.compile("/people/(\\d+)/");

    private String getPeopleIdFromUrl(String url){
        Matcher matcher = PEOPLE_ID_PATTERN.matcher(url);
        return matcher.find() ? matcher.group(1) : null;
    }

    public PersonDTO getCharacterByName(String name, List<String> characters){
        return characters
                .stream()
                .map(this::getPeopleIdFromUrl)
                .map(id -> peopleApiCall.getPersonById(id))
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
