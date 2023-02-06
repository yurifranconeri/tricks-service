package com.mysk8life.tricks.tricksrestservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.flogger.Flogger;

@Flogger
@Service
public class TricksService {

    @Autowired
    private TricksRepository repository;

    public TrickCollection getAllTricks() {
        return repository.findAllTricks();
    }

    public TrickCollection getAllTricksByStance(String stance) {
        if (isValid(stance) && Stance.isPresent(stance)) {
            log.atFine().log("Stance valid [ %s ]", stance);
            return repository.findTricksByStance(Stance.valueOf(stance.toUpperCase()));
        }
        
        log.atWarning().log("Stance not valid [ %s ]", stance);
        return emptyTricks();
    }

    public TrickCollection getAllTricksByCategory(String category) {
        if(isValid(category) && Category.isPresent(category)) {
            log.atFine().log("Category valid [ %s ]", category);
            return repository.findTricksByCategory(Category.valueOf(category.toUpperCase()));
        }

        log.atWarning().log("Category not valid [ %s ]", category);
        return emptyTricks();
    }

    public TrickCollection getAllTricksByDifficulty(String difficulty) {
        if(isValid(difficulty) && Difficulty.isPresent(difficulty)) {
            log.atFine().log("Difficulty valid [ %s ]", difficulty);
            return repository.findTricksByDifficulty(Difficulty.valueOf(difficulty.toUpperCase()));
        }

        log.atWarning().log("Difficulty not valid [ %s ]", difficulty);
        return emptyTricks();
    }

    public GroupedTricksCollection getAllTricksGrouped(String group) {
        if (isValid(group) && Group.isPresent(group)) {           
            log.atFine().log("Group valid [ %s ]", group);
            return groupTricks(group);    
        }

        log.atWarning().log("Group not valid [ %s ]", group);
        return emptyTricksGrouped();
    }

    public Set<Difficulty> getDifficulties() {
        return repository.findAllDifficulties();
    }

    public Set<Category> getCategories() {
        return repository.findAllCategories();
    }

    public Set<Stance> getStances() {
        return repository.findAllStances();
    }

    private GroupedTricksCollection groupTricks(String group) {
        if (group.equalsIgnoreCase(Group.CATEGORY.name())) {
            return repository.groupByCategory();
        }

        if (group.equalsIgnoreCase(Group.DIFFICULTY.name())) {
            return repository.groupByDifficulty();
        }

        log.atWarning().log("Group not valid [ %s ]", group);
        return emptyTricksGrouped();
    }

    private boolean isValid(String stringToEvaluate) {
        return !(stringToEvaluate == null || stringToEvaluate.isEmpty() || stringToEvaluate.isBlank());
    }

    private TrickCollection emptyTricks() {
        log.atFine().log("Empty TrickCollection");
        return TrickCollection.builder().tricks(new ArrayList<>()).build();
    }

    private GroupedTricksCollection emptyTricksGrouped() {
        log.atFine().log("Empty GroupedTricksCollection");
        return GroupedTricksCollection.builder().groupedTricks(new HashMap<>()).build();
    }
}
