package com.mysk8life.tricks.tricksrestservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TricksRepositoryTest {
    
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    @Autowired
    TricksRepository repository;

    @Test
    void getAllTricksShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findAllTricks());
    }

    @Test
    void getAllTricksShouldReturnTricksListNotNull() {
        assertNotNull(repository.findAllTricks().getTricks());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemPresent() {
        assertTrue(repository.findAllTricks().getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotNull() {
        assertNotNull(repository.findAllTricks().getTricks().stream().findFirst().get().getName());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotEmpty() {
        assertNotEquals(EMPTY,repository.findAllTricks().getTricks().stream().findFirst().get().getName());
    }

    @Test
    void getAllTricksShouldReturnTricksListFirstItemNameNotBlank() {
        assertNotEquals(BLANK,repository.findAllTricks().getTricks().stream().findFirst().get().getName());
    }


    @Test
    void getTricksByStanceRegularShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByStance(Stance.REGULAR));
    }

    @Test
    void getTricksByStanceSwitchShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByStance(Stance.SWITCH));
    }

    @Test
    void getTricksByStanceFakieShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByStance(Stance.FAKIE));
    }

    @Test
    void getTricksByStanceNollieShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByStance(Stance.NOLLIE));
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksNotNull() {
        assertNotNull(repository.findTricksByStance(null));
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksListNotNull() {
        assertNotNull(repository.findTricksByStance(null).getTricks());
    }

    @Test
    void getTricksByStanceNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(repository.findTricksByStance(null).getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getTricksByCategoryBasicShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByCategory(Category.BASIC));
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksNotNull() {
        assertNotNull(repository.findTricksByCategory(null));
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksListNotNull() {
        assertNotNull(repository.findTricksByCategory(null).getTricks());
    }

    @Test
    void getTricksByCategoryNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(repository.findTricksByCategory(null).getTricks().stream().findFirst().isPresent());
    }


    @Test
    void getTricksByDifficultyBasicShouldReturnTricksObjectNotNull() {
        assertNotNull(repository.findTricksByDifficulty(Difficulty.ONE));
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksNotNull() {
        assertNotNull(repository.findTricksByDifficulty(null));
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksListNotNull() {
        assertNotNull(repository.findTricksByDifficulty(null).getTricks());
    }

    @Test
    void getTricksByDifficultyNullShouldReturnTricksListFirstItemNotPresent() {
        assertFalse(repository.findTricksByDifficulty(null).getTricks().stream().findFirst().isPresent());
    }

    @Test
    void getDifficultiesShouldReturnDifficultiesObjectNotNull() {
        assertNotNull(repository.findAllDifficulties());
    }

    @Test
    void getDifficultiesShouldReturnDifficultiesObjectNotEmpty() {
        assertFalse(repository.findAllDifficulties().isEmpty());
    }

    @Test
    void getCategoriesShouldReturnCategoriesObjectNotNull() {
        assertNotNull(repository.findAllCategories());
    }

    @Test
    void getCategoriesShouldReturnCategoriesObjectNotEmpty() {
        assertFalse(repository.findAllCategories().isEmpty());
    }

    @Test
    void getStancesShouldReturnStancesObjectNotNull() {
        assertNotNull(repository.findAllStances());
    }

    @Test
    void getStancesShouldReturnStancesObjectNotEmpty() {
        assertFalse(repository.findAllStances().isEmpty());
    }

    @Test
    void groupByCategoryShouldReturnTrickGrouped(){
        assertNotNull(repository.groupByCategory());
    }

    @Test
    void groupByCategoryShouldReturnTrickGroupedMapNotEmpty(){
        assertFalse(repository.groupByCategory().groupedTricks.isEmpty());
    }

    @Test
    void groupByCategoryShouldReturnTrickGroupedMapKeyContainsBasic(){
        assertTrue(repository.groupByCategory().groupedTricks.containsKey(Category.BASIC.name()));
    }

    @Test
    void groupByDifficultyShouldReturnTrickGrouped(){
        assertNotNull(repository.groupByDifficulty());
    }

    @Test
    void groupByDifficultyShouldReturnTrickGroupedMapNotEmpty(){
        assertFalse(repository.groupByDifficulty().groupedTricks.isEmpty());
    }

    @Test
    void groupByDifficultyShouldReturnTrickGroupedMapKeyContainsBasic(){
        assertTrue(repository.groupByDifficulty().groupedTricks.containsKey(Difficulty.ONE.name()));
    }
}
