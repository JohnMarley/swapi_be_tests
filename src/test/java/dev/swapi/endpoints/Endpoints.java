package dev.swapi.endpoints;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Endpoints {

    public static final String FILMS = "/films";
    public static final String ALL_PEOPLE = "/people";
    public static final String PERSON = "/people/{personId}";
    public static final String STARSHIPS = "/starships/{shipId}";
}
