package dev.swapi.tests;

import dev.swapi.model.PersonDTO;
import dev.swapi.model.StarshipDTO;
import dev.swapi.utils.FilmUtils;
import dev.swapi.utils.PeopleUtils;
import dev.swapi.utils.StarShipsUtils;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SwApiTest {

    private static final String FILM_NAME = "A New Hope";
    private static final String PERSON = "Biggs Darklighter";
    private static final String STARSHIP_CLASS = "Starfighter";
    private static final String CHARACTER_NAME = "Luke Skywalker";

    private FilmUtils filmUtils;
    private PeopleUtils peopleUtils;
    private StarShipsUtils starShipsUtils;

    @BeforeAll
    public void setup(){
        RestAssured.baseURI = "https://swapi.dev/api";

        filmUtils = new FilmUtils();
        peopleUtils = new PeopleUtils();
        starShipsUtils = new StarShipsUtils();
    }

    @Test
    @DisplayName("Automation testing task #2 (API)")
    public void testAutoTask(){
        List<String> characters = filmUtils.getCharactersByFilmName(FILM_NAME);
        PersonDTO character = peopleUtils.getCharacterByName(PERSON, characters);
        List<StarshipDTO> starShips = starShipsUtils.getStarShips(character);

        SoftAssertions.assertSoftly(softAssertions ->
                starShips.forEach(starship -> {
                    softAssertions.assertThat(starship.getStarship_class())
                            .as("starship_class should be '" + STARSHIP_CLASS + "'")
                            .isEqualTo(STARSHIP_CLASS);
                    softAssertions.assertThat(peopleUtils.getCharacterByName(CHARACTER_NAME, starship.getPilots()))
                            .as("'"+ CHARACTER_NAME + "' is not among pilots that were also flying this kind of star")
                            .isNotNull();
                }));
    }
}
