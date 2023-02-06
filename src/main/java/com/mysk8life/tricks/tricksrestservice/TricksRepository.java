package com.mysk8life.tricks.tricksrestservice;

import java.util.Set;

public interface TricksRepository {
    public TrickCollection findAllTricks();

    public TrickCollection findTricksByStance(Stance stance);

    public TrickCollection findTricksByCategory(Category category);

    public TrickCollection findTricksByDifficulty(Difficulty difficulty);

    public GroupedTricksCollection groupByCategory();

    public GroupedTricksCollection groupByDifficulty();

    public Set<Difficulty> findAllDifficulties();

    public Set<Category> findAllCategories();

    public Set<Stance> findAllStances();
}
