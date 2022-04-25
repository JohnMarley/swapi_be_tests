package dev.swapi.utils;

import dev.swapi.caller.FilmsApiCall;

import java.util.List;

public class FilmUtils {

    private FilmsApiCall filmsApiCall = new FilmsApiCall();

    public List<String> getCharactersByFilmName(String filmName){
        return filmsApiCall.getFilms()
                .getResults()
                .stream()
                .filter(film -> film.getTitle().equals(filmName))
                .findFirst()
                .orElseThrow()
                .getCharacters();
    }
}
