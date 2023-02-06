package com.mysk8life.tricks.tricksrestservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TricksServiceTest {

    private static final String INVALID = "invalid";
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    @Autowired
    private TricksService service;

    @Test
    void getAllTricksShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricks());
    }

    @Test
    void getAllTricksShouldReturnTricksListNotNull() {
        assertNotNull(service.getAllTricks().getTricks());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemPresent() {
        assertTrue(service.getAllTricks().getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotNull() {
        assertNotNull(service.getAllTricks().getTricks().stream().findFirst().get().getName());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotEmpty() {
        assertNotEquals(EMPTY, service.getAllTricks().getTricks().stream().findFirst().get().getName());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotBlank() {
        assertNotEquals(BLANK, service.getAllTricks().getTricks().stream().findFirst().get().getName());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemDifficultyNotNull() {
        assertNotNull(service.getAllTricks().getTricks().stream().findFirst().get().getDifficulty());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemDifficultyNotEmpty() {
        assertNotEquals(EMPTY, service.getAllTricks().getTricks().stream().findFirst().get().getDifficulty().name());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemDifficultyNotBlank() {
        assertNotEquals(BLANK, service.getAllTricks().getTricks().stream().findFirst().get().getDifficulty().name());
    }

    @Test
    void getTricksByStanceRegularShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(Stance.REGULAR.toString()));
    }

    @Test
    void getTricksByStanceSwitchShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(Stance.SWITCH.toString()));
    }

    @Test
    void getTricksByStanceFakieShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(Stance.FAKIE.toString()));
    }

    @Test
    void getTricksByStanceNollieShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(Stance.NOLLIE.toString()));
    }

    @Test
    void getTricksByStanceInvalidShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(INVALID));
    }

    @Test
    void getTricksByStanceEmptyShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(EMPTY));
    }

    @Test
    void getTricksByStanceBlankShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByStance(BLANK));
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksNotNull() {
        assertNotNull(service.getAllTricksByStance(null));
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksListNotNull() {
        assertNotNull(service.getAllTricksByStance(null).getTricks());
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(service.getAllTricksByStance(null).getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getTricksByCategoryBasicShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByCategory(Category.BASIC.toString()));
    }

    @Test
    void getTricksByCategoryInvalidShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByCategory(INVALID));
    }

    @Test
    void getTricksByCategoryEmptyShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByCategory(EMPTY));
    }

    @Test
    void getTricksByCategoryBlankShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByCategory(BLANK));
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksNotNull() {
        assertNotNull(service.getAllTricksByCategory(null));
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksListNotNull() {
        assertNotNull(service.getAllTricksByCategory(null).getTricks());
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(service.getAllTricksByCategory(null).getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getTricksByDifficultyOneShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(Difficulty.ONE.toString()));
    }

    @Test
    void getTricksByDifficultyInvalidShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(INVALID));
    }

    @Test
    void getTricksByDifficultyEmptyShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(EMPTY));
    }

    @Test
    void getTricksByDifficultyBlankShouldReturnTricksObjectNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(BLANK));
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(null));
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksListNotNull() {
        assertNotNull(service.getAllTricksByDifficulty(null).getTricks());
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(service.getAllTricksByDifficulty(null).getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getDifficultiesShouldReturnDifficultiesObjectNotNull() {
        assertNotNull(service.getDifficulties());
    }

    @Test
    void getDifficultiesShouldReturnDifficultiesObjectNotEmpty() {
        assertFalse(service.getDifficulties().isEmpty());
    }

    @Test
    void getCategoriesShouldReturnCategoriesObjectNotNull() {
        assertNotNull(service.getCategories());
    }

    @Test
    void getCategoriesShouldReturnCategoriesObjectNotEmpty() {
        assertFalse(service.getCategories().isEmpty());
    }

    @Test
    void getStancesShouldReturnStancesObjectNotNull() {
        assertNotNull(service.getStances());
    }

    @Test
    void getStancesShouldReturnStancesObjectNotEmpty() {
        assertFalse(service.getStances().isEmpty());
    }

    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedEmptyWhenNull() {
        assertNotNull(service.getAllTricksGrouped(null));
    }
    
    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedEmptyWhenEmpty() {
        assertNotNull(service.getAllTricksGrouped(EMPTY));
    }
    
    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedEmptyWhenBlank() {
        assertNotNull(service.getAllTricksGrouped(BLANK));
    }

    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedEmptyWhenInvalid() {
        assertNotNull(service.getAllTricksGrouped(INVALID));
    }

    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedWhenValidDifficulty() {
        assertNotNull(service.getAllTricksGrouped(Group.DIFFICULTY.name()));
    }

    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedWhenValidIgnoreCase() {
        assertNotNull(service.getAllTricksGrouped(Group.DIFFICULTY.name().toLowerCase()));
    }

    @Test
    void getAllTricksGroupedShouldReturnTricksGroupedWhenValidCategory() {
        assertTrue(service.getAllTricksGrouped(Group.CATEGORY.name()).groupedTricks.keySet().contains(Category.BASIC.name()));
    }
}