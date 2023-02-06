package com.mysk8life.tricks.tricksrestservice;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.flogger.Flogger;

@Flogger
@RestController
@RequestMapping("api/v1/tricks")
public class TricksRestController {
    
    @Autowired
    private TricksService tricksService;

    @GetMapping
    public TrickCollection getTricks() {
        log.atFine().log("Getting all tricks");
        return tricksService.getAllTricks();
    }
    
    @GetMapping(value = "/group/{group}")
    public GroupedTricksCollection getAllGrouped(@PathVariable String group) {
        log.atFine().log("Getting tricks grouped by [ %s ]", group);
        return tricksService.getAllTricksGrouped(group);
    }

    @GetMapping(value = "/stances")
    public Set<Stance> getStances() {
        log.atFine().log("Getting stances");
        return tricksService.getStances();
    }

    @GetMapping(value = "/stance/{stance}")
    public TrickCollection getAllByStance(@PathVariable String stance) {
        log.atFine().log("Getting tricks filtered by stance [ %s ]", stance);
        return tricksService.getAllTricksByStance(stance);
    }

    @GetMapping(value = "/categories")
    public Set<Category> getCategories() {
        log.atFine().log("Getting categories");
        return tricksService.getCategories();
    }

    @GetMapping(value = "/category/{category}")
    public TrickCollection getAllByCategory(@PathVariable String category) {
        log.atFine().log("Getting tricks filtered by category [ %s ]", category);
        return tricksService.getAllTricksByCategory(category);
    }

    @GetMapping(value = "/difficulties")
    public Set<Difficulty> getDifficulties() {
        log.atFine().log("Getting difficulties");
        return tricksService.getDifficulties();
    }

    @GetMapping(value = "/difficulty/{difficulty}")
    public TrickCollection getAllByDifficulty(@PathVariable String difficulty) {
        log.atFine().log("Getting tricks filtered by difficulty [ %s ]", difficulty);
        return tricksService.getAllTricksByDifficulty(difficulty);
    }
}
